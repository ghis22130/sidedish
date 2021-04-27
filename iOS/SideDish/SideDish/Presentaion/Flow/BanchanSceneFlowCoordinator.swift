//
//  BanchanSceneFlowCoordinator.swift
//  SideDish
//
//  Created by 심영민 on 2021/04/27.
//

import UIKit

protocol BanchanSceneFlowCoordinatorDependencies {
    func makeBanchanListViewController(action: BanchanListViewModelAction) -> BanchanListViewController
    func makeBanchanDetailViewController(hash: Int) -> BanchanDetailViewController
}

class BanchanSceneFlowCoordinator {
    
    private weak var navigationController: UINavigationController?
    private var banchanListVC: BanchanListViewController?
    private let dependencies: BanchanSceneFlowCoordinatorDependencies
    
    init(navigationController: UINavigationController, dependencies: BanchanSceneFlowCoordinatorDependencies) {
        self.navigationController = navigationController
        self.dependencies = dependencies
    }
    
    func start() {
        let action = BanchanListViewModelAction(showBanchanDetails: showBanchanDetails(banchan:))
        let vc = dependencies.makeBanchanListViewController(action: action)
        self.navigationController?.pushViewController(vc, animated: true)
        self.banchanListVC = vc
    }
    
    func showBanchanDetails(banchan: Banchan) {
        let vc = dependencies.makeBanchanDetailViewController(hash: banchan.detailHash)
        self.navigationController?.pushViewController(vc, animated: true)
    }
}
