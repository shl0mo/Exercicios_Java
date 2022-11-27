import java.util.ArrayList;

class Ensalamento {
	ArrayList<Sala> salas;
	ArrayList<Turma> turmas;
	ArrayList<TurmaEmSala> ensalamento;


	Ensalamento () {
		this.salas = new ArrayList<Sala>();
		this.turmas = new ArrayList<Turma>();
		this.ensalamento = new ArrayList<TurmaEmSala>();
	}

	public void addSala (Sala sala) {
		this.salas.add(sala);
	}

	public void addTurma (Turma turma) {
		this.turmas.add(turma);
	}

	public Sala getSala (Turma turma) {
		Sala sala_ensalamento = null;
		for (int i = 0; i < this.ensalamento.size(); i++) {
			if (this.ensalamento.get(i).turma == turma) sala_ensalamento = this.ensalamento.get(i).sala;
		}
		return sala_ensalamento;
	}

	public boolean salaDisponivel (Sala sala, int horario) {
		boolean sala_disponivel = true;
		for (int i = 0; i < this.ensalamento.size(); i++) {
			if (this.ensalamento.get(i).sala == sala) {
				for (int j = 0; j < this.ensalamento.get(i).turma.horarios.size(); j++) {
					if (this.ensalamento.get(i).turma.horarios.get(j) == horario) sala_disponivel = false;
				}
			}
		}
		return sala_disponivel;
	}

	public boolean salaDisponivel (Sala sala, ArrayList<Integer> horarios) {
		boolean horarios_disponiveis = false;
		for (int i = 0; i < horarios.size(); i++) {
			if (salaDisponivel(sala, horarios.get(i)) == true) horarios_disponiveis = true;
		}
		return horarios_disponiveis;
	}

	public boolean alocar (Turma turma, Sala sala) {
		if (turma.acessivel == false || sala.acessivel == false) return false;
		if (turma.numAlunos > sala.capacidade) return false;
		if (salaDisponivel(sala, turma.horarios) == false) return false;
		TurmaEmSala nova_turma_sala = new TurmaEmSala(turma, sala);
		this.ensalamento.add(nova_turma_sala);
		return true;
	}

	public void alocarTodas () {
		int total_alunos_turmas = 0;
		for (Turma turma: this.turmas) {
			total_alunos_turmas = total_alunos_turmas + turma.numAlunos;
		}
		boolean alocou = false;
		for (Sala sala: this.salas) {
			if (sala.capacidade >= total_alunos_turmas) {
				alocou = true;
				for (Turma turma: this.turmas) {
					alocar(turma, sala);
					break;
				}
			}
		}
		/*if (!alocou && salas.size() == 1) {
			int numero_turmas_alocar = 0;
			Turma turma_alocar = null;
			for (Turma turma: this.turmas) {
				if (turma.numAlunos <= this.salas.get(0).capacidade) turma_alocar = turma;
			}
			alocar(turma_alocar, this.salas.get(0));
		}*/
		if (!alocou) {
			for (int i = 0; i < this.turmas.size(); i++) {
				for (int j = 0; j < this.salas.size(); j++) {
					if (alocar(this.turmas.get(i), this.salas.get(j)) == true) continue;
					//alocar(this.turmas.get(i), this.salas.get(j));
				}
			}
		}
	}

	public int getTotalTurmasAlocadas () {
		int total_alocados = 0;
		for (int i = 0; i < this.ensalamento.size(); i++) {
			if (this.ensalamento.get(i).sala != null) total_alocados = total_alocados + 1; 
		}
		return total_alocados;
	}

	public int getTotalEspacoLivre () {
		int eficiencia = 0;
		for (TurmaEmSala turma_sala: this.ensalamento) {
			eficiencia = eficiencia + turma_sala.sala.capacidade - turma_sala.turma.numAlunos;
		}
		return eficiencia;
	}

	public String relatorioResumoEnsalamento () {
		return "Total de Salas: " + this.salas.size() + "\nTotal de Turmas: " + this.turmas.size() + "\nTurmas Alocadas: " + getTotalTurmasAlocadas() + "\nEspaços Livres: " + getTotalEspacoLivre();
	}

	public String relatorioTurmasPorSala () {
		String string_turma_sala = "";
		string_turma_sala = string_turma_sala + relatorioResumoEnsalamento() + "\n\n";
		for (Sala sala: this.salas) {
			string_turma_sala = string_turma_sala + "--- Bloco " + sala.bloco + ", Sala " + sala.sala + " (" + sala.capacidade + " lugares, ";
			if (sala.acessivel == true) string_turma_sala = string_turma_sala + "acessível) ---\n\n";
			else string_turma_sala = string_turma_sala + "não acessível) ---\n\n";
			for (TurmaEmSala turma_sala: this.ensalamento) {
				if (turma_sala.sala == sala) string_turma_sala = string_turma_sala + turma_sala.turma.getDescricao() + "\n\n";
			}
		}
		return string_turma_sala;
	}

	/*public String relatorioSalasPorTurma () {
		String string_sala_turma = "";
		string_sala_turma = string_sala_turma + relatorioResumoEnsalamento() + "\n\n";
		for () {
			
		}
	}*/

	public String relatorioSalasPorTurma () {
		String string_sala_turma = "";
		string_sala_turma = string_sala_turma + relatorioResumoEnsalamento() + "\n\n";
		/*for (TurmaEmSala turma_sala: this.ensalamento) {
			string_sala_turma = string_sala_turma + turma_sala.turma.getDescricao() + "\n";
			if (turma_sala.sala == null) string_sala_turma = string_sala_turma + "SEM SALA";
			else string_sala_turma = string_sala_turma + turma_sala.turma.getDescricao() + "\nSala: Bloco " + turma_sala.sala.bloco + ", Sala " + turma_sala.sala.sala + " (" + turma_sala.sala.capacidade + " lugares, ";
		}*/
		for (Turma turma: this.turmas) {
			string_sala_turma = string_sala_turma + turma.getDescricao() + "\n";
			boolean encontrou = false;
			for (TurmaEmSala sala_turma: this.ensalamento) {
				if (turma == sala_turma.turma) {
					encontrou = true;
					string_sala_turma = string_sala_turma + "Sala: Bloco " + sala_turma.sala.bloco + ", Sala " + sala_turma.sala.sala + " (" + sala_turma.sala.capacidade + " lugares, ";
					if (sala_turma.sala.acessivel == true) string_sala_turma = string_sala_turma + "acessível)\n\n";
					else string_sala_turma = string_sala_turma + "não acessível)\n\n";
				}
			}		
			if (!encontrou) {
				string_sala_turma = string_sala_turma + "Sala: SEM SALA";
				continue;
			}
		}
		return string_sala_turma;
	}
}
