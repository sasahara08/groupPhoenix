package dto;

public enum GenderEnum {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int value;

    GenderEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GenderEnum fromValue(int value) {
        for (GenderEnum gender : values()) {
            if (gender.value == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("不正な性別の値: " + value);
    }
}
