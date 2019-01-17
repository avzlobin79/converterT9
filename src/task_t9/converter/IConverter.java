package task_t9.converter;

public interface IConverter<T1, T2> {

	T2 convert(T1 input);

}
