package racingcar.game;

import racingcar.validate.InputValidator;
import racingcar.validate.TryNumValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();
    private final TryNumValidator tryNumValidator = new TryNumValidator();

    public void Start(){

        outputView.inputCarNameMessage();
        String input = inputView.readCarNames();
        inputValidator.validateInput(input);

        outputView.inputTryNumMessage();
        int tryNum = inputView.readTryNum();
        tryNumValidator.validateTryNum(tryNum);


    }
}
