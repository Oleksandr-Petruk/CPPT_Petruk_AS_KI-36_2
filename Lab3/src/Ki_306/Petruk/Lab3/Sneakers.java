
package Ki_306.Petruk.Lab3;

/**
 * Клас Sneakers, що представляє кросівки. Наслідує клас Shoes та реалізує інтерфейс ShoeOperations.
 */
public class Sneakers extends Shoes implements ShoeOperations {

    /**
     * Конструктор для створення кросівок.
     *
     * @param brand Бренд кросівок.
     * @param size Розмір кросівок.
     * @param color Колір кросівок.
     */
    public Sneakers(String brand, double size, String color) {
        super(brand, size, color);
    }

    /** Одягає кросівки, якщо вони не одягнуті. */
    @Override
    public void wear() {
        if (isWorn()) {
            System.out.println("Кросівки вже одягнені.");
        } else {
            setWorn(true);
            System.out.println("Кросівки одягнені.");
            logOperation("Кросівки одягнені.");
        }
    }

    /** Знімає кросівки, якщо вони надягнуті. */
    @Override
    public void remove() {
        if (!isWorn()) {
            System.out.println("Кросівки вже зняті.");
        } else {
            setWorn(false);
            System.out.println("Кросівки зняті.");
            logOperation("Кросівки зняті.");
        }
    }

    /** Очищає кросівки. */
    @Override
    public void clean() {
        System.out.println("Кросівки очищені.");
        logOperation("Кросівки очищені.");
    }

    /** Відремонтувати кросівки, якщо вони зняті. */
    @Override
    public void repair() {
        if (isWorn()) {
            System.out.println("Спочатку зніміть кросівки, щоб відремонтувати їх.");
        } else {
            System.out.println("Кросівки відремонтовані.");
            logOperation("Кросівки відремонтовані.");
            addDistance(-100); // Скидаємо пробіг на 100 км після ремонту
        }
    }

    /** Відполірувати кросівки, якщо вони зняті. */
    @Override
    public void polish() {
        if (isWorn()) {
            System.out.println("Спочатку зніміть кросівки, щоб відполірувати їх.");
        } else {
            System.out.println("Кросівки відполіровані.");
            logOperation("Кросівки відполіровані.");
        }
    }

    /** Зав'язує шнурки, якщо кросівки надягнуті. */
    @Override
    public void laceUp() {
        if (!isWorn()) {
            System.out.println("Спочатку одягніть кросівки, щоб зав'язати шнурки.");
        } else if (isLaced()) {
            System.out.println("Шнурки вже зав'язані.");
        } else {
            setLaced(true);
            System.out.println("Шнурки зав'язані.");
            logOperation("Шнурки зав'язані.");
        }
    }

    /** Розв'язує шнурки, якщо вони зав'язані. */
    @Override
    public void unlace() {
        if (!isLaced()) {
            System.out.println("Шнурки вже розв'язані.");
        } else {
            setLaced(false);
            System.out.println("Шнурки розв'язані.");
            logOperation("Шнурки розв'язані.");
        }
    }

    /**
     * Перевіряє та виводить поточний стан кросівок.
     */
    @Override
    public void checkStatus() {
        String status = "Бренд: " + getBrand() + ", Розмір: " + getSize() + ", Колір: " + getColor() +
                ", Шнурки зав'язані: " + (isLaced() ? "так" : "ні") +
                ", Одягнені: " + (isWorn() ? "так" : "ні") +
                ", Пробіг: " + getDistanceRun() + " км";
        if (needsRepair()) {
            status += " (Потребує ремонту)";
        }
        System.out.println(status);
        logOperation("Перевірено стан: " + status);
    }

    /**
     * Виконує пробіг на задану відстань, якщо кросівки в належному стані.
     *
     * @param distance Відстань для пробігу в км.
     */
    public void run(double distance) {
        if (needsRepair()) {
            System.out.println("Кросівки потребують ремонту. Спочатку відремонтуйте їх, щоб знову бігати.");
            return;
        }

        if (!isLaced()) {
            System.out.println("Потрібно зав'язати шнурки перед пробігом.");
            return;
        }

        addDistance(distance);
        System.out.println("Ви пробігли " + distance + " км.");
        logOperation("Пробігли " + distance + " км.");
        if (needsRepair()) {
            System.out.println("Кросівки потребують ремонту після пробігу 100 км.");
        }
    }

    /**
     * Записує проведену операцію в log-файл.
     *
     * @param operation Опис операції для запису в log-файл.
     */
    private void logOperation(String operation) {
        // Тут буде код для запису в log-файл.
    }
}
