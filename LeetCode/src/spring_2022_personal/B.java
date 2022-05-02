package spring_2022_personal;

public class B {


    private int[] materials;
    private int[][] cookbooks;
    private int[][] attributes;
    private int limit;
    private int ansMax = -1;

    private void rec(int idx, int[] leftMaterials, int tmpM, int tmpB) {
        if (idx == cookbooks.length) {
            if (tmpB >= limit) {
                ansMax = Math.max(ansMax, tmpM);
            }
            return;
        }

        int chooseRes = 0;
        int[] cookbook = cookbooks[idx];
        int[] attr = attributes[idx];
        boolean isOk = true;
        for (int i = 0; i < 5; i++) {
            if (leftMaterials[i] < cookbook[i]) {
                isOk = false;
                break;
            }
        }

        rec(idx + 1, leftMaterials, tmpM, tmpB);
        // 选择
        if (isOk) {
            for (int i = 0; i < 5; i++) {
                leftMaterials[i] -= cookbook[i];
            }
            rec(idx + 1, leftMaterials, tmpM + attr[0], tmpB + attr[1]);
            for (int i = 0; i < 5; i++) {
                leftMaterials[i] += cookbook[i];
            }
        }
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.materials = materials;
        this.cookbooks = cookbooks;
        this.attributes = attribute;
        this.limit = limit;
        rec(0, materials, 0, 0);
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
