# matrix_generator.py

def generate_matrix(size, fill_char):
    """
    Генерує матрицю, що містить заштриховані області навколо ромбу в центрі.

    :param size: Розмір квадратної матриці (int)
    :param fill_char: Символ-заповнювач (str)
    :return: Список списків (матриця)
    """
    matrix = []

    # Генерація матриці
    for i in range(size):
        row = []
        for j in range(size):
            # Визначення меж ромбу (порожньої області)
            if abs(i - j) > size // 2 or (i + j < size // 2) or (i + j >= size + size // 2):
                row.append(fill_char)  # Заштриховані області
            else:
                row.append(" ")  # Порожні клітинки (ромб)
        matrix.append(row)
    return matrix


def print_matrix(matrix):
    """
    Виводить матрицю в консоль.

    :param matrix: Матриця (список списків)
    """
    for row in matrix:
        print("".join(row))


def main():
    """
    Основна функція програми.
    """
    try:
        # Введення розміру матриці
        size = int(input("Введіть розмір квадратної матриці (непарне число): "))
        if size <= 0 or size % 2 == 0:
            raise ValueError("Розмір матриці має бути додатним непарним числом.")

        # Введення символу-заповнювача
        fill_char = input("Введіть символ-заповнювач: ")
        if len(fill_char) != 1:
            raise ValueError("Потрібно ввести один символ.")

        # Генерація та виведення матриці
        matrix = generate_matrix(size, fill_char)
        print("\nЗгенерована матриця:")
        print_matrix(matrix)

    except ValueError as e:
        print(f"Помилка: {e}")


if __name__ == "__main__":
    main()
