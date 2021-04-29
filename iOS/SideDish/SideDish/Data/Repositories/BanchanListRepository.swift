//
//  BanchanListRepository.swift
//  SideDish
//
//  Created by 심영민 on 2021/04/27.
//

import CoreData
import Combine

protocol BanchanListRepository {
    func fetchBanchanList(section: Section, completion: @escaping ([Banchan]?) -> Void)
}

class DefaultBanchanListRepository: BanchanListRepository {
    private let network: NetworkService
    private let banchanListStorage = CoreDataBanchanListStorage()
    private var subscriptions = Set<AnyCancellable>()
    
    init(network: NetworkService) {
        self.network = network
    }
    
    func fetchBanchanList(section: Section, completion: @escaping ([Banchan]?) -> Void) {
//        let request: NSFetchRequest = BanchanSectionEntity.fetchRequest()
//        banchanListStorage.deleteAll(request: request)

        banchanListStorage.fetch(section: section) { result in
            switch result {
            case .success(let banchans):
                completion(banchans)
            case .failure(_):
                let endPoint = BanchanAPIEndpoint(path: section.path(), httpMethod: .get)
                self.network.request(with: endPoint, dataType: BanchanListDTO.self)
                    .sink(receiveCompletion: { result in
                        switch result {
                        case .failure(let error):
                            print(error)
                        case .finished:
                            break
                        }
                    }, receiveValue: { banchanListDTO in
                        self.banchanListStorage.save(section: section, requestDTO: banchanListDTO)
                        completion(banchanListDTO.toDomain())
                    })
                    .store(in: &self.subscriptions)
            }
        }
    }
}
