package by.academy.pharmacy.entity;

public enum Role {
    /**
     * Contains type of user called "Administrator".
     */
    ADMINISTRATOR,
    /**
     * Contains type of user called "Pharmacist".
     */
    PHARMACIST,
    /**
     * Contains type of user called "Client".
     */
    CLIENT;

    /**
     * Returns Role enum constant with the specified name.
     *
     * @param ordinal serial number of enum constant.
     * @return Role enum constant.
     */
    public static Role valueOfOrdinal(final int ordinal) {
        return switch (ordinal) {
            case 0 -> Role.ADMINISTRATOR;
            case 1 -> Role.PHARMACIST;
            case 2 -> Role.CLIENT;
            default -> null;
        };
    }
}
