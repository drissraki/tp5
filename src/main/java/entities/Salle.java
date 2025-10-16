package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Machine> machines = new ArrayList<>();

    // Constructors
    public Salle() {}
    public Salle(String code) {
        this.code = code;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public List<Machine> getMachines() { return machines; }
    public void setMachines(List<Machine> machines) { this.machines = machines; }

    // Helper methods to manage bidirectional relationship
    public void addMachine(Machine machine) {
        machines.add(machine);
        machine.setSalle(this);
    }

    public void removeMachine(Machine machine) {
        machines.remove(machine);
        machine.setSalle(null);
    }

    @Override
    public String toString() {
        return "Salle{id=" + id + ", code='" + code + "'}";
    }
}
