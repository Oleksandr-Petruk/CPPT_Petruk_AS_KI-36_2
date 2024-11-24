from shoes import Shoes

class Sneakers(Shoes):
    """
    Клас Sneakers, що представляє кросівки. Наслідує клас Shoes та реалізує інтерфейс ShoeOperations.
    """

    def __init__(self, brand, size, color):
        """
        Конструктор для створення кросівок.

        :param brand: Бренд кросівок.
        :param size: Розмір кросівок.
        :param color: Колір кросівок.
        """
        super().__init__(brand, size, color)

    def wear(self):
        """
        Одягає кросівки, якщо вони не одягнуті.
        """
        if self.is_worn():
            print("Кросівки вже одягнені.")
        else:
            self.set_worn(True)
            print("Кросівки одягнені.")
            self.log_operation("Кросівки одягнені.")

    def remove(self):
        """
        Знімає кросівки, якщо вони надягнуті.
        """
        if not self.is_worn():
            print("Кросівки вже зняті.")
        else:
            self.set_worn(False)
            print("Кросівки зняті.")
            self.log_operation("Кросівки зняті.")

    def clean(self):
        """
        Очищає кросівки.
        """
        print("Кросівки очищені.")
        self.log_operation("Кросівки очищені.")

    def repair(self):
        """
        Відремонтувати кросівки, якщо вони зняті.
        """
        if self.is_worn():
            print("Спочатку зніміть кросівки, щоб відремонтувати їх.")
        else:
            print("Кросівки відремонтовані.")
            self.log_operation("Кросівки відремонтовані.")
            self.add_distance(-100)  # Скидаємо пробіг на 100 км після ремонту

    def polish(self):
        """
        Відполірувати кросівки, якщо вони зняті.
        """
        if self.is_worn():
            print("Спочатку зніміть кросівки, щоб відполірувати їх.")
        else:
            print("Кросівки відполіровані.")
            self.log_operation("Кросівки відполіровані.")

    def lace_up(self):
        """
        Зав'язує шнурки, якщо кросівки надягнуті.
        """
        if not self.is_worn():
            print("Спочатку одягніть кросівки, щоб зав'язати шнурки.")
        elif self.is_laced():
            print("Шнурки вже зав'язані.")
        else:
            self.set_laced(True)
            print("Шнурки зав'язані.")
            self.log_operation("Шнурки зав'язані.")

    def unlace(self):
        """
        Розв'язує шнурки, якщо вони зав'язані.
        """
        if not self.is_laced():
            print("Шнурки вже розв'язані.")
        else:
            self.set_laced(False)
            print("Шнурки розв'язані.")
            self.log_operation("Шнурки розв'язані.")

    def check_status(self):
        """
        Перевіряє та виводить поточний стан кросівок.
        """
        status = (
            f"Бренд: {self.get_brand()}, Розмір: {self.get_size()}, Колір: {self.get_color()}, "
            f"Шнурки зав'язані: {'так' if self.is_laced() else 'ні'}, "
            f"Одягнені: {'так' if self.is_worn() else 'ні'}, "
            f"Пробіг: {self.get_distance_run()} км"
        )
        if self.needs_repair():
            status += " (Потребує ремонту)"
        print(status)
        self.log_operation(f"Перевірено стан: {status}")

    def run(self, distance):
        """
        Виконує пробіг на задану відстань, якщо кросівки в належному стані.

        :param distance: Відстань для пробігу в км.
        """
        if self.needs_repair():
            print("Кросівки потребують ремонту. Спочатку відремонтуйте їх.")
            return

        if not self.is_laced():
            print("Потрібно зав'язати шнурки перед пробігом.")
            return

        self.add_distance(distance)
        print(f"Ви пробігли {distance} км.")
        self.log_operation(f"Пробігли {distance} км.")
        if self.needs_repair():
            print("Кросівки потребують ремонту після пробігу 100 км.")

    def log_operation(self, operation):
        """
        Записує проведену операцію в log-файл.
        """
        # Тут буде код для запису в log-файл.
        pass

