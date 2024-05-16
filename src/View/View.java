package View;

import Model.Exception.MyException;

public interface View {
    void start() throws MyException, Exception;
    void answer(String text);
}

