package hello.core.sigleton;

import org.junit.jupiter.api.Test;

public class SingleTonService {

  //클래스 레벨에 한개만 존재함
  private static final SingleTonService instance = new SingleTonService();

  //생성자를 막음 (객체는 한개만 있는 것)
  private SingleTonService(){
  }
  //하나의 객체만을 내보냄
  public static SingleTonService getInstance(){
    return instance;
  }

}
