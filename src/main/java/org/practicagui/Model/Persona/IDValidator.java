package org.practicagui.Model.Persona;

public class IDValidator {

    private static int parseToInt(String numCandidate) {
        int number = -1;
        try {
            number = Integer.parseInt(numCandidate);
        } catch (NumberFormatException e) {
            return number;
        }
        return number;
    }

    public static boolean validarDni(String dni) {
        int dniInt = parseToInt(dni);
        if (dniInt != -1) {
            return (dniInt >= 1000000) && (dniInt <= 99999999);
        }
        return false;
    }
}
