---

Reactive Extensions

http://reactivex.io/documentation/observable.html document

Observable

onNext = 아이템을 받는다. 

onComplete = 스트림이 끝났다.

onError = 스트림을 받아오는 도중에 에러가 생겼다.



- Observable, Flowable, Single, Completable
- 

Subject

- PublishSubject, BehaviorSubject

Operator

- map, flatmap, doOn..., combineLatest, zip, concat



iterable, observable을 쓰면 무엇이 좋은가?

- 가독성

- 유지보수

  

iterable, observable 의 차이는 무엇인가?

| `Iterable`                                                   | `Observable`                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `getDataFromLocalMemory().skip(10).take(5)   .map({ s -> return s + " transformed" })   .forEach({ println "next => " + it })` | `getDataFromNetwork().skip(10).take(5)    .map({ s -> return s + " transformed" })   .subscribe({ println "onNext => " + it })` |