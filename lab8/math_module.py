import math
import struct

def calculate_expression(x_values):
    """
    Обчислює значення виразу y = tg(x) * ctg(2x) для заданих значень x.

    :param x_values: Список значень x
    :return: Список обчислених значень y
    """
    results = []
    for x in x_values:
        try:
            y = math.tan(x) * (1 / math.tan(2 * x))  # ctg(2x) = 1 / tan(2x)
            results.append(y)
        except ZeroDivisionError:
            # Обробка випадку, коли tan(2x) = 0 (нескінченність)
            results.append(float('inf'))  # Позначення для нескінченності
    return results


def write_to_text_file(filename, x_values, y_values):
    """
    Записує результати обчислень у текстовий файл.

    :param filename: Назва файлу
    :param x_values: Список значень x
    :param y_values: Список значень y
    """
    with open(filename, 'w') as file:
        file.write("x, y\n")
        for x, y in zip(x_values, y_values):
            file.write(f"{x:.6f}, {y:.6f}\n")


def read_from_text_file(filename):
    """
    Читає результати обчислень з текстового файлу.

    :param filename: Назва файлу
    :return: Список пар (x, y)
    """
    results = []
    with open(filename, 'r') as file:
        lines = file.readlines()[1:]  # Пропускаємо заголовок
        for line in lines:
            x, y = map(float, line.strip().split(','))
            results.append((x, y))
    return results


def write_to_binary_file(filename, x_values, y_values):
    """
    Записує результати обчислень у двійковий файл.

    :param filename: Назва файлу
    :param x_values: Список значень x
    :param y_values: Список значень y
    """
    with open(filename, 'wb') as file:
        for x, y in zip(x_values, y_values):
            file.write(struct.pack('ff', x, y))  # float (4 байти)


def read_from_binary_file(filename):
    """
    Читає результати обчислень з двійкового файлу.

    :param filename: Назва файлу
    :return: Список пар (x, y)
    """
    results = []
    with open(filename, 'rb') as file:
        while chunk := file.read(8):  # Читаємо по 8 байтів (2 float)
            x, y = struct.unpack('ff', chunk)
            results.append((x, y))
    return results


def main():
    """
    Основна функція для запуску програми.
    """
    try:
        # Введення даних
        x_values = list(map(float, input("Введіть значення x через пробіл: ").split()))

        # Обчислення
        y_values = calculate_expression(x_values)

        # Виведення результатів на екран
        print("Результати обчислень:")
        for x, y in zip(x_values, y_values):
            print(f"x = {x:.6f}, y = {y:.6f}")

        # Запис у текстовий файл
        text_filename = "results.txt"
        write_to_text_file(text_filename, x_values, y_values)
        print(f"Результати записано у текстовий файл: {text_filename}")

        # Запис у двійковий файл
        binary_filename = "results.bin"
        write_to_binary_file(binary_filename, x_values, y_values)
        print(f"Результати записано у двійковий файл: {binary_filename}")

        # Читання з текстового файлу
        print("\nРезультати, прочитані з текстового файлу:")
        text_results = read_from_text_file(text_filename)
        for x, y in text_results:
            print(f"x = {x:.6f}, y = {y:.6f}")

        # Читання з двійкового файлу
        print("\nРезультати, прочитані з двійкового файлу:")
        binary_results = read_from_binary_file(binary_filename)
        for x, y in binary_results:
            print(f"x = {x:.6f}, y = {y:.6f}")

    except ValueError:
        print("Помилка: введіть коректні числові значення x через пробіл.")
    except Exception as e:
        print(f"Сталася помилка: {e}")


if __name__ == "__main__":
    main()
