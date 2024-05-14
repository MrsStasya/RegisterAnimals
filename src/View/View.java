package View;

import Model.Exception.MyException;

public interface View {
    void start() throws MyException;
    void answer(String text);
}

