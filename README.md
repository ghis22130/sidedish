# sidedish
그룹프로젝트 #2

# 배포주소 
ec2-54-180-115-20.ap-northeast-2.compute.amazonaws.com:8080

Team 10

## 팀원

### iOS
- dumba
- Min

### Backend
- Bongf
- K

## 브랜치 전략

폴더를 iOS와 BE 두개로 나누어서 관리합니다.

main : 배포용 브랜치

dev/iOS, dev/BE : 주 개발 브랜치

review/iOS, review/BE : upstream 리뷰용 브랜치, dev에서 시작하도록 함.

기능 추가 : 기능 이름에 맞게 자유롭게 설정합니다. dev에서 시작해서 dev로 pull request.

## 커밋 규칙

```
# <type>: <Title>

##################################################


# 본문은 위에 작성
########################################################################

# 꼬릿말은 아래에 작성: ex) #이슈 번호

# --- COMMIT END ---
# <타입> 리스트
#   feat    : 기능 (새로운 기능)
#   fix     : 버그 (버그 수정)
#   refactor: 리팩토링
#   style   : 스타일 (코드 형식, 세미콜론 추가: 비즈니스 로직에 변경 없음)
#   docs    : 문서 (문서 추가, 수정, 삭제)
#   test    : 테스트 (테스트 코드 추가, 수정, 삭제: 비즈니스 로직에 변경 없음)
#   chore   : 기타 변경사항 (빌드 스크립트 수정 등)
# ------------------
#     제목 첫 글자를 대문자로
#     제목은 명령문으로
#     제목 끝에 마침표(.) 금지
#     제목과 본문을 한 줄 띄워 분리하기
#     본문은 "어떻게" 보다 "무엇을", "왜"를 설명한다.
#     본문에 여러줄의 메시지를 작성할 땐 "-"로 구분
# ------------------
```

