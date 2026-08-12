package racingcar.validate;

public class TryNumValidator {

    public void validateTryNum(int tryNum){
        if(tryNum <= 0){
            throw new IllegalArgumentException("시도횟수는 1미만일 수 없습니다.");
        }
    }
}
