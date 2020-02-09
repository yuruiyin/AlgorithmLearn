package problem901_1000;

public class Problem984 {

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < A || j < B;) {
            if (A - i > B - j) {
                if (i < A) {
                    if (i + 2 <= A) {
                        sb.append("aa");
                        i += 2;
                    } else {
                        sb.append("a");
                        i++;
                    }
                }

                if (j < B) {
                    sb.append("b");
                    j++;
                }
            } else if (A - i == B - j) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a') {
                    if (j < B) {
                        if (j + 2 <= B) {
                            sb.append("bb");
                            j += 2;
                        } else {
                            sb.append("b");
                            j++;
                        }
                    }

                    if (i < A) {
                        if (i + 2 <= A) {
                            sb.append("aa");
                            i += 2;
                        } else {
                            sb.append("a");
                            i++;
                        }
                    }

                } else {
                    if (i < A) {
                        if (i + 2 <= A) {
                            sb.append("aa");
                            i += 2;
                        } else {
                            sb.append("a");
                            i++;
                        }
                    }

                    if (j < B) {
                        if (j + 2 <= B) {
                            sb.append("bb");
                            j += 2;
                        } else {
                            sb.append("b");
                            j++;
                        }
                    }

                }

            } else {
                if (j < B) {
                    if (j + 2 <= B) {
                        sb.append("bb");
                        j += 2;
                    } else {
                        sb.append("b");
                        j++;
                    }
                }

                if (i < A) {
                    sb.append("a");
                    i++;
                }

            }
        }

        return sb.toString();
    }

}
