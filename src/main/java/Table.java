public class Table {
    private Team[] sortingTeams;
    public Table(Team[] dataBaseTeams ){
        this.sortingTeams = dataBaseTeams;
    }
    void printTable() {

        int k = 0;
        for (int j = 0; j < sortingTeams.length - 1; j++) {
            for (int i = 0; i < sortingTeams.length - 1; i++) {
                if (sortingTeams[i].getPoints() < sortingTeams[i + 1].getPoints()) {
                    Team a = sortingTeams[i];
                    sortingTeams[i] = sortingTeams[i + 1];
                    sortingTeams[i + 1] = a;
                } else if (sortingTeams[i].getPoints() == sortingTeams[i + 1].getPoints()) {
                    if (sortingTeams[i].getGoalsScored() - sortingTeams[i].getGoalsLosed() < sortingTeams[i + 1].getGoalsScored() - sortingTeams[i + 1].getGoalsLosed()) {
                        Team a = sortingTeams[i];
                        sortingTeams[i] = sortingTeams[i + 1];
                        sortingTeams[i + 1] = a;
                    }
                }
            }
        }
        System.out.printf("Team             | games | points | wins | loses | draws | goals | \n");
        for (int i = 0 ; i < sortingTeams.length; i ++)
        {
            System.out.printf("%-16s | %5d | %6d | %4d | %5d | %5d | %+5d |\n",sortingTeams[i].getName(),sortingTeams[i].getGames(),sortingTeams[i].getPoints(),sortingTeams[i].getWins(),sortingTeams[i].getLoses(),sortingTeams[i].getDraw(),sortingTeams[i].getGoalsScored()-sortingTeams[i].getGoalsLosed());

        }

    }
}
