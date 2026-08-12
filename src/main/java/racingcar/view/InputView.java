package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames(){
        System.out.println("자동차 이름을 입력하세요(자동차 이름은 쉼표(,)로 구분해주세요)");
        return Console.readLine();
    }

    public int inputTryNum() {
        System.out.println("자동차가 이동을 시도할 횟수를 입력하세요");
        return Integer.parseInt(Console.readLine());
    }
}
