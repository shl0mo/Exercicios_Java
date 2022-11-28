import java.util.ArrayList;

class EnsalamentoMain {
	public static void main (String args[]) {
		Sala s1 = new Sala(1, 1, 30, true);
		s1.getDescricao();
		ArrayList<Integer> horarios = new ArrayList<Integer>();
		horarios.add(1);
		horarios.add(2);
		horarios.add(3);
		Turma t1 = new Turma("Turma 1", "Professor 1", 20, true);
		t1.addHorario(1);
		t1.getHorariosString();
		t1.getDescricao();
		TurmaEmSala turma_sala = new TurmaEmSala(t1, s1);
		Ensalamento ensalamento = new Ensalamento();
		ensalamento.addTurma(t1);
		ensalamento.addSala(s1);
		ensalamento.getSala(t1);
		ensalamento.salaDisponivel(s1, 1);
		ensalamento.salaDisponivel(s1, 3);
		ensalamento.salaDisponivel(s1, horarios);
		ensalamento.alocar(t1, s1);
		ensalamento.alocarTodas();
		ensalamento.getTotalTurmasAlocadas();
		ensalamento.getTotalEspacoLivre();
		ensalamento.relatorioResumoEnsalamento();
		ensalamento.relatorioTurmasPorSala();
		ensalamento.relatorioSalasPorTurma();
	}
}
