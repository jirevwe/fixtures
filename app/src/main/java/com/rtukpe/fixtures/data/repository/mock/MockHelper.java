package com.rtukpe.fixtures.data.repository.mock;

import com.google.gson.Gson;
import com.rtukpe.fixtures.data.model.FixturesResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MockHelper implements MockerInterface {

    String fixtures = "{\"timeFrameStart\":\"2018-04-24\",\"timeFrameEnd\":\"2018-04-25\",\"count\":20,\"fixtures\":[{\"id\":161698,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Stade Brestois\",\"homeTeamId\":512,\"awayTeamName\":\"Clermont Foot Auvergne\",\"awayTeamId\":541,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":162013,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"RC Tours\",\"homeTeamId\":544,\"awayTeamName\":\"Quevilly Rouen\",\"awayTeamId\":1807,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161701,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Chamois Niortais FC\",\"homeTeamId\":557,\"awayTeamName\":\"Gazélec Ajaccio\",\"awayTeamId\":555,\"result\":{\"goalsHomeTeam\":4,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161695,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Ajaccio AC\",\"homeTeamId\":510,\"awayTeamName\":\"RC Lens\",\"awayTeamId\":546,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161696,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"AJ Auxerre\",\"homeTeamId\":519,\"awayTeamName\":\"Stade de Reims\",\"awayTeamId\":547,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":4,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161697,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"IN_PLAY\",\"matchday\":35,\"homeTeamName\":\"Paris FC\",\"homeTeamId\":1045,\"awayTeamName\":\"LB Châteauroux\",\"awayTeamId\":539,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0},\"odds\":null},{\"id\":161699,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Le Havre AC\",\"homeTeamId\":533,\"awayTeamName\":\"AS Nancy\",\"awayTeamId\":520,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161700,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Nîmes Olympique\",\"homeTeamId\":556,\"awayTeamName\":\"FC Lorient\",\"awayTeamId\":525,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161702,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"US Orleans\",\"homeTeamId\":742,\"awayTeamName\":\"FC Bourg-en-Bresse Péronnas\",\"awayTeamId\":1042,\"result\":{\"goalsHomeTeam\":5,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161703,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"FC Valenciennes\",\"homeTeamId\":515,\"awayTeamName\":\"Sochaux FC\",\"awayTeamId\":517,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":159427,\"competitionId\":446,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":38,\"homeTeamName\":\"Derby County\",\"homeTeamId\":342,\"awayTeamName\":\"Cardiff City FC\",\"awayTeamId\":715,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":160015,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Oldham Athletic AFC\",\"homeTeamId\":1075,\"awayTeamName\":\"Southend United FC\",\"awayTeamId\":1069,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":3,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":160107,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":27,\"homeTeamName\":\"Bristol Rovers\",\"homeTeamId\":400,\"awayTeamName\":\"Wigan Athletic FC\",\"awayTeamId\":75,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160008,\"compet\n" +
            "itionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Shrewsbury Town FC\",\"homeTeamId\":1080,\"awayTeamName\":\"Peterborough United FC\",\"awayTeamId\":1077,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":159988,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":37,\"homeTeamName\":\"Bradford City AFC\",\"homeTeamId\":1067,\"awayTeamName\":\"Milton Keynes Dons\",\"awayTeamId\":409,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":159965,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":39,\"homeTeamName\":\"Doncaster Rovers FC\",\"homeTeamId\":1071,\"awayTeamName\":\"Blackburn Rovers FC\",\"awayTeamId\":59,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160006,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Rochdale AFC\",\"homeTeamId\":361,\"awayTeamName\":\"Plymouth Argyle\",\"awayTeamId\":1138,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160559,\"competitionId\":448,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Newport County\",\"homeTeamId\":1142,\"awayTeamName\":\"Accrington Stanley\",\"awayTeamId\":1145,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160554,\"competitionId\":448,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Coventry City FC\",\"homeTeamId\":1076,\"awayTeamName\":\"Lincoln City\",\"awayTeamId\":1126,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":4,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":3}},\"odds\":null},{\"id\":166840,\"competitionId\":464,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":9,\"homeTeamName\":\"Liverpool FC\",\"homeTeamId\":64,\"awayTeamName\":\"AS Roma\",\"awayTeamId\":100,\"result\":{\"goalsHomeTeam\":5,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0}},\"odds\":null}]}";

    String teams = "{\n" +
            "    \"count\": 20,\n" +
            "    \"teams\": [\n" +
            "        {\n" +
            "            \"id\": 742,\n" +
            "            \"name\": \"US Orleans\",\n" +
            "            \"shortName\": \"Orleans\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/fr/thumb/2/2b/Union_sportive_Orléans_Loiret_football_2.jpg/200px-Union_sportive_Orléans_Loiret_football_2.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 520,\n" +
            "            \"name\": \"AS Nancy\",\n" +
            "            \"shortName\": \"Nancy\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/8/8f/AS_Nancy_Logo.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1045,\n" +
            "            \"name\": \"Paris FC\",\n" +
            "            \"shortName\": \"Paris\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"https://upload.wikimedia.org/wikipedia/de/b/be/Logo_ParisFC_2011.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 541,\n" +
            "            \"name\": \"Clermont Foot Auvergne\",\n" +
            "            \"shortName\": \"Clermont\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/a/a1/Clermont_Foot_Auvergne.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 512,\n" +
            "            \"name\": \"Stade Brestois\",\n" +
            "            \"shortName\": \"Brest\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/c/cb/Stade_Brestois_29.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 539,\n" +
            "            \"name\": \"LB Châteauroux\",\n" +
            "            \"shortName\": \"Châteauroux\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/4/42/La_Berrichonne_de_Châteauroux.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 556,\n" +
            "            \"name\": \"Nîmes Olympique\",\n" +
            "            \"shortName\": \"Nîmes\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/b/b6/Olympique_Nimes.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 547,\n" +
            "            \"name\": \"Stade de Reims\",\n" +
            "            \"shortName\": \"Reims\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/9/9e/Stade_Reims_Logo.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 557,\n" +
            "            \"name\": \"Chamois Niortais FC\",\n" +
            "            \"shortName\": \"Niort\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/0/0a/Chamois_Niort_Logo.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 510,\n" +
            "            \"name\": \"Ajaccio AC\",\n" +
            "            \"shortName\": \"Ajaccio\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/5/58/AC_Ajaccio.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 515,\n" +
            "            \"name\": \"FC Valenciennes\",\n" +
            "            \"shortName\": \"Valenciennes\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/e/eb/Valenciennes_AFC_(2008).svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 555,\n" +
            "            \"name\": \"Gazélec Ajaccio\",\n" +
            "            \"shortName\": \"Ajaccio\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/en/4/46/Gazélec_Ajaccio_logo.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 517,\n" +
            "            \"name\": \"Sochaux FC\",\n" +
            "            \"shortName\": \"Sochaux\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/a/ae/FC_Sochaux_Logo_2010.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1042,\n" +
            "            \"name\": \"FC Bourg-en-Bresse Péronnas\",\n" +
            "            \"shortName\": \"FC Bourg-Péronnas\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"https://upload.wikimedia.org/wikipedia/fr/6/66/Football_Bourg_en_Bresse_Péronnas_logo.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 544,\n" +
            "            \"name\": \"RC Tours\",\n" +
            "            \"shortName\": \"Tours\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/9/9a/FC_Tours.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 533,\n" +
            "            \"name\": \"Le Havre AC\",\n" +
            "            \"shortName\": \"Le HAC\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/4/47/Le_Havre_AC.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 525,\n" +
            "            \"name\": \"FC Lorient\",\n" +
            "            \"shortName\": \"Lorient\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/c/c4/FC_Lorient_neu.png\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1807,\n" +
            "            \"name\": \"Quevilly Rouen\",\n" +
            "            \"shortName\": null,\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 519,\n" +
            "            \"name\": \"AJ Auxerre\",\n" +
            "            \"shortName\": \"Auxerre\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/5/5b/AJ_Auxerre.svg\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 546,\n" +
            "            \"name\": \"RC Lens\",\n" +
            "            \"shortName\": \"Lens\",\n" +
            "            \"squadMarketValue\": null,\n" +
            "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/d/d7/RC_Lens_Logo.svg\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Inject
    MockHelper() {
    }

    @Override
    public Observable<FixturesResponse> getMockFixtures() {
        return Observable.just(new Gson().fromJson(fixtures, FixturesResponse.class));
    }

    @Override
    public Observable<TeamsResponse> getMockTeams() {
        return Observable.just(new Gson().fromJson(teams, TeamsResponse.class));
    }

}
