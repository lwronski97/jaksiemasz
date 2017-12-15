package visualizer;

import employee.TeamManager;

public class MenagerVisualizer {

    private final TeamManager teamManager;

    public MenagerVisualizer(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    public String visualize() {
        return visualize("");
    }

    public String visualize(String indent) {
        StringBuilder stringVisualizeMenager = new StringBuilder();
        TeamManager employeeTeamManager = teamManager;
        employeeTeamManager.getSubordinates().forEach(e -> stringVisualizeMenager.append(indent + new CompanyVisualizer(e).visualize(indent + "    ")));
        return stringVisualizeMenager.toString();
    }

}
