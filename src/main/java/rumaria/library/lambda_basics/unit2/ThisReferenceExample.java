package rumaria.library.lambda_basics.unit2;

public class ThisReferenceExample {

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "anonymous inner class yang keluar";
            }
        });

        thisReferenceExample.execute();
    }

    private void doProcess(int i, Process process) {
        process.process(i);
    }

    private void execute() {
        this.doProcess(10, i -> System.out.println(this));
    }

    @Override
    public String toString() {
        return "ini toString() nya ThisReferenceExample";
    }
}
