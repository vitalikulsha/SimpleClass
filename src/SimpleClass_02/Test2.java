package SimpleClass_02;

/* Task 02
2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами.
Добавьте конструктор, инициализирующий члены класса по умолчанию.
Добавьте set- и get- методы для полей экземпляра класса.
 */
public class Test2 {
    int variableFirst;
    int variableSecond;

    public Test2() {
        this.variableFirst = 0;
        this.variableSecond = 0;
    }

    public Test2(int variableFirst, int variableSecond) {
        this.variableFirst = variableFirst;
        this.variableSecond = variableSecond;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "variableFirst=" + variableFirst +
                ", variableSecond=" + variableSecond +
                '}';
    }

    public int getVariableFirst() {
        return variableFirst;
    }

    public void setVariableFirst(int variableFirst) {
        this.variableFirst = variableFirst;
    }

    public int getVariableSecond() {
        return variableSecond;
    }

    public void setVariableSecond(int variableSecond) {
        this.variableSecond = variableSecond;
    }
}
