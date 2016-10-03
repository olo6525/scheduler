# 개발방식
git-flow 방식으로 진행한다.<br />
[참조](http://ohgyun.com/402)<br />

  
브랜치는 아래와 같은 구조로 같는다.<br />
feature < develop < release < hotfixes < master <br />


  
왼쪽에서 오른쪽으로 병합되어야 한다.<br />

## 예시
`작업 순서`<br />
1. `develop` 브랜치에서 새로운 `feature` 브랜치를 만든다.<br />
2. `feature` 브랜치에서 작업을 완료 했으면 `develop` 브랜치에 병합한다.<br />
3. 모든 기능이 완료되었으면 `release` 브랜치에 병합한다.<br />
4. `release` 브랜치에서 `master` 브랜치로 병합한다.<br />

> 여기서 중요한 점은 대부분의 인원은 `develop` 브랜치에서 `feature` 브랜치로 분기시켜 작업 후 `develop` 브랜치 까지 병합하는 작업만 해야한다는 것이다.

## git flow
![Alt text](http://nvie.com/img/git-model@2x.png)





