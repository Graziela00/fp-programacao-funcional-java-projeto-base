package exercicios;

import exercicios.base.Aula;

import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Aula_6 extends Aula_4 {
    private final Predicate<Estudante> mulheresAprovadas =
            estudante -> estudante.getSexo() == 'F' && estudante.getCurso() != null && estudante.getNota() >= 6;

    public Aula_6() {
        System.out.println("Mulheres Aprovadas:");
        getEstudantesMulheresAprovadas().forEach(System.out::println);

        System.out.println("\nMulheres Aprovadas Ordenadas por Curso e Nota:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota().forEach(System.out::println);

        System.out.println("\nMulheres Aprovadas Ordenadas por Curso Decrescente e Nota Crescente:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente().forEach(System.out::println);

        System.out.println("\nMulheres Aprovadas Não Ordenadas Modificável:");
        getEstudantesMulheresAprovadasNaoOrdenadasModificavel().forEach(System.out::println);

        System.out.println("\nMulheres Aprovadas Ordenadas Totalmente Decrescente:");
        getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente().forEach(System.out::println);

        System.out.println("\nMulheres Aprovadas Ordenadas por Curso Crescente e Nota Decrescente:");
        getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Aula06();
    }

    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator.comparing(Estudante::getCurso).thenComparing(Estudante::getNota))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator.comparing(Estudante::getCurso, Comparator.reverseOrder()).thenComparing(Estudante::getNota))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(Collectors.toList());
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator.comparing(Estudante::getCurso, Comparator.reverseOrder()).thenComparing(Estudante::getNota, Comparator.reverseOrder()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(Comparator.comparing(Estudante::getCurso).thenComparing(Estudante::getNota, Comparator.reverseOrder()))
                .collect(Collectors.toUnmodifiableList());
    }
}
