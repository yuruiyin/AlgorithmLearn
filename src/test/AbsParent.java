package test;

public abstract class AbsParent {

    private static AbsParent mInstance;

    public static AbsParent getInstance(String className) {
        if (mInstance == null) {
            try {
                Class clazz = Class.forName(className);
                mInstance = (Child) clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return mInstance;
    }
}
