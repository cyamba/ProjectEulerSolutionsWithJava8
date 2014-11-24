import com.yambacode.solutions.AbstractEulerSolver

class GroovyEuler1 extends AbstractEulerSolver {


    @Override
    String doSolve() {
        return (1..1000).findAll { it % 3 == 0 || it % 5 == 0 }.sum()
    }

    public static void main(String[] args) {
        new GroovyEuler1().solve()
    }
}