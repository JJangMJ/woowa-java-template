package template.controller;

import java.util.function.Supplier;
import template.view.InputView;
import template.view.OutputView;

public class XController {
    private final InputView inputView;
    private final OutputView outputView;

    public XController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

    }

    // return 값이 있는 경우 사용.
    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return readWithRetry(supplier);
        }
    }

    // return 값 없는 void인 경우 사용.
    private void runWithRetry(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            runWithRetry(runnable);
        }
    }
}
