package ind.gopinnath.javaexamples;

import java.util.function.Function;

@FunctionalInterface
public interface SafeFunction<T, R, E extends Throwable> {

	R apply(T value) throws E;

	static <T, R, E extends Throwable> Function<T, R> safe(SafeFunction<T, R, E> unsafeFunction) {
		return value -> {
			try {
				return (value == null || "".equals(value))?null:unsafeFunction.apply(value);
			} catch (Throwable exception) {
				throw new RuntimeException(exception);
			}
		};
	}

}
