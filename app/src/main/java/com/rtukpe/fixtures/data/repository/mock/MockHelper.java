package com.rtukpe.fixtures.data.repository.mock;

import com.google.gson.Gson;
import com.rtukpe.fixtures.data.model.FixturesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MockHelper implements MockerInterface {

        String data = "{\n" +
            "    \"timeFrameStart\": \"2018-04-25\",\n" +
            "    \"timeFrameEnd\": \"2018-05-01\",\n" +
            "    \"count\": 146,\n" +
            "    \"fixtures\": [\n" +
            "        {\n" +
            "            \"id\": 166838,\n" +
            "            \"competitionId\": 464,\n" +
            "            \"date\": \"2018-04-25T18:45:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 9,\n" +
            "            \"homeTeamName\": \"FC Bayern München\",\n" +
            "            \"homeTeamId\": 5,\n" +
            "            \"awayTeamName\": \"Real Madrid CF\",\n" +
            "            \"awayTeamId\": 86,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162556,\n" +
            "            \"competitionId\": 453,\n" +
            "            \"date\": \"2018-04-27T16:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"Arminia Bielefeld\",\n" +
            "            \"homeTeamId\": 38,\n" +
            "            \"awayTeamName\": \"1. FC Kaiserslautern\",\n" +
            "            \"awayTeamId\": 13,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162557,\n" +
            "            \"competitionId\": 453,\n" +
            "            \"date\": \"2018-04-27T16:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"VfL Bochum\",\n" +
            "            \"homeTeamId\": 36,\n" +
            "            \"awayTeamName\": \"Erzgebirge Aue\",\n" +
            "            \"awayTeamId\": 22,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161694,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Sochaux FC\",\n" +
            "            \"homeTeamId\": 517,\n" +
            "            \"awayTeamName\": \"FC Lorient\",\n" +
            "            \"awayTeamId\": 525,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161693,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Stade de Reims\",\n" +
            "            \"homeTeamId\": 547,\n" +
            "            \"awayTeamName\": \"Chamois Niortais FC\",\n" +
            "            \"awayTeamId\": 557,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161692,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"AS Nancy\",\n" +
            "            \"homeTeamId\": 520,\n" +
            "            \"awayTeamName\": \"RC Tours\",\n" +
            "            \"awayTeamId\": 544,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161691,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"RC Lens\",\n" +
            "            \"homeTeamId\": 546,\n" +
            "            \"awayTeamName\": \"Paris FC\",\n" +
            "            \"awayTeamId\": 1045,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162012,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Quevilly Rouen\",\n" +
            "            \"homeTeamId\": 1807,\n" +
            "            \"awayTeamName\": \"FC Valenciennes\",\n" +
            "            \"awayTeamId\": 515,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161686,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"FC Bourg-en-Bresse Péronnas\",\n" +
            "            \"homeTeamId\": 1042,\n" +
            "            \"awayTeamName\": \"Stade Brestois\",\n" +
            "            \"awayTeamId\": 512,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161687,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"LB Châteauroux\",\n" +
            "            \"homeTeamId\": 539,\n" +
            "            \"awayTeamName\": \"AJ Auxerre\",\n" +
            "            \"awayTeamId\": 519,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161688,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Clermont Foot Auvergne\",\n" +
            "            \"homeTeamId\": 541,\n" +
            "            \"awayTeamName\": \"Nîmes Olympique\",\n" +
            "            \"awayTeamId\": 556,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161689,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Gazélec Ajaccio\",\n" +
            "            \"homeTeamId\": 555,\n" +
            "            \"awayTeamName\": \"US Orleans\",\n" +
            "            \"awayTeamId\": 742,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 161690,\n" +
            "            \"competitionId\": 451,\n" +
            "            \"date\": \"2018-04-27T18:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Le Havre AC\",\n" +
            "            \"homeTeamId\": 533,\n" +
            "            \"awayTeamName\": \"Ajaccio AC\",\n" +
            "            \"awayTeamId\": 510,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162254,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-27T18:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"TSG 1899 Hoffenheim\",\n" +
            "            \"homeTeamId\": 2,\n" +
            "            \"awayTeamName\": \"Hannover 96\",\n" +
            "            \"awayTeamId\": 8,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162878,\n" +
            "            \"competitionId\": 455,\n" +
            "            \"date\": \"2018-04-27T19:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 35,\n" +
            "            \"homeTeamName\": \"Levante UD\",\n" +
            "            \"homeTeamId\": 88,\n" +
            "            \"awayTeamName\": \"Sevilla FC\",\n" +
            "            \"awayTeamId\": 559,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162558,\n" +
            "            \"competitionId\": 453,\n" +
            "            \"date\": \"2018-04-28T11:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"SV Darmstadt 98\",\n" +
            "            \"homeTeamId\": 55,\n" +
            "            \"awayTeamName\": \"1. FC Union Berlin\",\n" +
            "            \"awayTeamId\": 28,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162559,\n" +
            "            \"competitionId\": 453,\n" +
            "            \"date\": \"2018-04-28T11:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"Dynamo Dresden\",\n" +
            "            \"homeTeamId\": 35,\n" +
            "            \"awayTeamName\": \"Fortuna Düsseldorf\",\n" +
            "            \"awayTeamId\": 24,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162564,\n" +
            "            \"competitionId\": 453,\n" +
            "            \"date\": \"2018-04-28T11:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"FC St. Pauli\",\n" +
            "            \"homeTeamId\": 20,\n" +
            "            \"awayTeamName\": \"SpVgg Greuther Fürth\",\n" +
            "            \"awayTeamId\": 21,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162876,\n" +
            "            \"competitionId\": 455,\n" +
            "            \"date\": \"2018-04-28T11:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 35,\n" +
            "            \"homeTeamName\": \"RCD Espanyol\",\n" +
            "            \"homeTeamId\": 80,\n" +
            "            \"awayTeamName\": \"UD Las Palmas\",\n" +
            "            \"awayTeamId\": 275,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158969,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T11:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Liverpool FC\",\n" +
            "            \"homeTeamId\": 64,\n" +
            "            \"awayTeamName\": \"Stoke City FC\",\n" +
            "            \"awayTeamId\": 70,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164300,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Ascoli\",\n" +
            "            \"homeTeamId\": 446,\n" +
            "            \"awayTeamName\": \"Perugia\",\n" +
            "            \"awayTeamId\": 452,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164301,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"AS Bari\",\n" +
            "            \"homeTeamId\": 431,\n" +
            "            \"awayTeamName\": \"Virtus Entella\",\n" +
            "            \"awayTeamId\": 747,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164302,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Carpi FC\",\n" +
            "            \"homeTeamId\": 713,\n" +
            "            \"awayTeamName\": \"AS Avellino 1912\",\n" +
            "            \"awayTeamId\": 486,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164303,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"AC Cesena\",\n" +
            "            \"homeTeamId\": 591,\n" +
            "            \"awayTeamName\": \"Frosinone Calcio\",\n" +
            "            \"awayTeamId\": 470,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164304,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"AS Cittadella\",\n" +
            "            \"homeTeamId\": 466,\n" +
            "            \"awayTeamName\": \"Foggia\",\n" +
            "            \"awayTeamId\": 1822,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164305,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Empoli FC\",\n" +
            "            \"homeTeamId\": 445,\n" +
            "            \"awayTeamName\": \"Novara Calcio\",\n" +
            "            \"awayTeamId\": 587,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164306,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Pro Vercelli\",\n" +
            "            \"homeTeamId\": 590,\n" +
            "            \"awayTeamName\": \"Parma FC\",\n" +
            "            \"awayTeamId\": 112,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164307,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Salernitana Calcio\",\n" +
            "            \"homeTeamId\": 455,\n" +
            "            \"awayTeamName\": \"Brescia Calcio\",\n" +
            "            \"awayTeamId\": 449,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164308,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Spezia Calcio\",\n" +
            "            \"homeTeamId\": 488,\n" +
            "            \"awayTeamName\": \"Cremonese\",\n" +
            "            \"awayTeamId\": 457,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164309,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Ternana Calcio\",\n" +
            "            \"homeTeamId\": 479,\n" +
            "            \"awayTeamName\": \"Pescara Calcio\",\n" +
            "            \"awayTeamId\": 585,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 164310,\n" +
            "            \"competitionId\": 459,\n" +
            "            \"date\": \"2018-04-28T13:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 38,\n" +
            "            \"homeTeamName\": \"Venezia\",\n" +
            "            \"homeTeamId\": 454,\n" +
            "            \"awayTeamName\": \"US Cittá di Palermo\",\n" +
            "            \"awayTeamId\": 114,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162251,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-28T13:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"FC Bayern München\",\n" +
            "            \"homeTeamId\": 5,\n" +
            "            \"awayTeamName\": \"Eintracht Frankfurt\",\n" +
            "            \"awayTeamId\": 19,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162252,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-28T13:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"SC Freiburg\",\n" +
            "            \"homeTeamId\": 17,\n" +
            "            \"awayTeamName\": \"1. FC Köln\",\n" +
            "            \"awayTeamId\": 1,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162253,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-28T13:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"Hertha BSC\",\n" +
            "            \"homeTeamId\": 9,\n" +
            "            \"awayTeamName\": \"FC Augsburg\",\n" +
            "            \"awayTeamId\": 16,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162256,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-28T13:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"FC Schalke 04\",\n" +
            "            \"homeTeamId\": 6,\n" +
            "            \"awayTeamName\": \"Bor. Mönchengladbach\",\n" +
            "            \"awayTeamId\": 18,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 162258,\n" +
            "            \"competitionId\": 452,\n" +
            "            \"date\": \"2018-04-28T13:30:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 32,\n" +
            "            \"homeTeamName\": \"VfL Wolfsburg\",\n" +
            "            \"homeTeamId\": 11,\n" +
            "            \"awayTeamName\": \"Hamburger SV\",\n" +
            "            \"awayTeamId\": 7,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158972,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Southampton FC\",\n" +
            "            \"homeTeamId\": 340,\n" +
            "            \"awayTeamName\": \"AFC Bournemouth\",\n" +
            "            \"awayTeamId\": 1044,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158966,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Burnley FC\",\n" +
            "            \"homeTeamId\": 328,\n" +
            "            \"awayTeamName\": \"Brighton & Hove Albion\",\n" +
            "            \"awayTeamId\": 397,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158967,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Crystal Palace FC\",\n" +
            "            \"homeTeamId\": 354,\n" +
            "            \"awayTeamName\": \"Leicester City FC\",\n" +
            "            \"awayTeamId\": 338,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158968,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Huddersfield Town\",\n" +
            "            \"homeTeamId\": 394,\n" +
            "            \"awayTeamName\": \"Everton FC\",\n" +
            "            \"awayTeamId\": 62,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 158971,\n" +
            "            \"competitionId\": 445,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 36,\n" +
            "            \"homeTeamName\": \"Newcastle United FC\",\n" +
            "            \"homeTeamId\": 67,\n" +
            "            \"awayTeamName\": \"West Bromwich Albion FC\",\n" +
            "            \"awayTeamId\": 74,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159342,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Hull City FC\",\n" +
            "            \"homeTeamId\": 322,\n" +
            "            \"awayTeamName\": \"Cardiff City FC\",\n" +
            "            \"awayTeamId\": 715,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159341,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Fulham FC\",\n" +
            "            \"homeTeamId\": 63,\n" +
            "            \"awayTeamName\": \"Sunderland AFC\",\n" +
            "            \"awayTeamId\": 71,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159340,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Burton Albion FC\",\n" +
            "            \"homeTeamId\": 1072,\n" +
            "            \"awayTeamName\": \"Bolton Wanderers FC\",\n" +
            "            \"awayTeamId\": 60,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159339,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Barnsley FC\",\n" +
            "            \"homeTeamId\": 357,\n" +
            "            \"awayTeamName\": \"Brentford FC\",\n" +
            "            \"awayTeamId\": 402,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159338,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Aston Villa FC\",\n" +
            "            \"homeTeamId\": 58,\n" +
            "            \"awayTeamName\": \"Derby County\",\n" +
            "            \"awayTeamId\": 342,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159343,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Middlesbrough FC\",\n" +
            "            \"homeTeamId\": 343,\n" +
            "            \"awayTeamName\": \"Millwall FC\",\n" +
            "            \"awayTeamId\": 384,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159344,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Norwich City FC\",\n" +
            "            \"homeTeamId\": 68,\n" +
            "            \"awayTeamName\": \"Leeds United\",\n" +
            "            \"awayTeamId\": 341,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159349,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Wolverhampton Wanderers FC\",\n" +
            "            \"homeTeamId\": 76,\n" +
            "            \"awayTeamName\": \"Sheffield Wednesday\",\n" +
            "            \"awayTeamId\": 345,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159348,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Sheffield United FC\",\n" +
            "            \"homeTeamId\": 356,\n" +
            "            \"awayTeamName\": \"Preston North End\",\n" +
            "            \"awayTeamId\": 1081,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159347,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Reading\",\n" +
            "            \"homeTeamId\": 355,\n" +
            "            \"awayTeamName\": \"Ipswich Town\",\n" +
            "            \"awayTeamId\": 349,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159346,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Queens Park Rangers\",\n" +
            "            \"homeTeamId\": 69,\n" +
            "            \"awayTeamName\": \"Birmingham City\",\n" +
            "            \"awayTeamId\": 332,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159345,\n" +
            "            \"competitionId\": 446,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Nottingham Forest\",\n" +
            "            \"homeTeamId\": 351,\n" +
            "            \"awayTeamName\": \"Bristol City\",\n" +
            "            \"awayTeamId\": 387,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159890,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Blackpool FC\",\n" +
            "            \"homeTeamId\": 336,\n" +
            "            \"awayTeamName\": \"Shrewsbury Town FC\",\n" +
            "            \"awayTeamId\": 1080,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159891,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Bradford City AFC\",\n" +
            "            \"homeTeamId\": 1067,\n" +
            "            \"awayTeamName\": \"Southend United FC\",\n" +
            "            \"awayTeamId\": 1069,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159892,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Bristol Rovers\",\n" +
            "            \"homeTeamId\": 400,\n" +
            "            \"awayTeamName\": \"Gillingham FC\",\n" +
            "            \"awayTeamId\": 370,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159893,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Bury FC\",\n" +
            "            \"homeTeamId\": 1068,\n" +
            "            \"awayTeamName\": \"Portsmouth\",\n" +
            "            \"awayTeamId\": 325,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159894,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Charlton Athletic\",\n" +
            "            \"homeTeamId\": 348,\n" +
            "            \"awayTeamName\": \"Blackburn Rovers FC\",\n" +
            "            \"awayTeamId\": 59,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159895,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Milton Keynes Dons\",\n" +
            "            \"homeTeamId\": 409,\n" +
            "            \"awayTeamName\": \"Scunthorpe United FC\",\n" +
            "            \"awayTeamId\": 1078,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159897,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Oxford United\",\n" +
            "            \"homeTeamId\": 1082,\n" +
            "            \"awayTeamName\": \"Rochdale AFC\",\n" +
            "            \"awayTeamId\": 361,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159896,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Oldham Athletic AFC\",\n" +
            "            \"homeTeamId\": 1075,\n" +
            "            \"awayTeamName\": \"Doncaster Rovers FC\",\n" +
            "            \"awayTeamId\": 1071,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159901,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Wigan Athletic FC\",\n" +
            "            \"homeTeamId\": 75,\n" +
            "            \"awayTeamName\": \"AFC Wimbledon\",\n" +
            "            \"awayTeamId\": 347,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159900,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Walsall FC\",\n" +
            "            \"homeTeamId\": 369,\n" +
            "            \"awayTeamName\": \"Northampton Town\",\n" +
            "            \"awayTeamId\": 376,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159899,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Plymouth Argyle\",\n" +
            "            \"homeTeamId\": 1138,\n" +
            "            \"awayTeamName\": \"Rotherham United\",\n" +
            "            \"awayTeamId\": 385,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 159898,\n" +
            "            \"competitionId\": 447,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Peterborough United FC\",\n" +
            "            \"homeTeamId\": 1077,\n" +
            "            \"awayTeamName\": \"Fleetwood Town FC\",\n" +
            "            \"awayTeamId\": 1073,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 160445,\n" +
            "            \"competitionId\": 448,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Colchester United FC\",\n" +
            "            \"homeTeamId\": 365,\n" +
            "            \"awayTeamName\": \"Swindon Town FC\",\n" +
            "            \"awayTeamId\": 1079,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 160444,\n" +
            "            \"competitionId\": 448,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Chesterfield FC\",\n" +
            "            \"homeTeamId\": 363,\n" +
            "            \"awayTeamName\": \"Wycombe Wanderers\",\n" +
            "            \"awayTeamId\": 1146,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 160442,\n" +
            "            \"competitionId\": 448,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Accrington Stanley\",\n" +
            "            \"homeTeamId\": 1145,\n" +
            "            \"awayTeamName\": \"Lincoln City\",\n" +
            "            \"awayTeamId\": 1126,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 160443,\n" +
            "            \"competitionId\": 448,\n" +
            "            \"date\": \"2018-04-28T14:00:00Z\",\n" +
            "            \"status\": \"TIMED\",\n" +
            "            \"matchday\": 45,\n" +
            "            \"homeTeamName\": \"Cheltenham Town\",\n" +
            "            \"homeTeamId\": 411,\n" +
            "            \"awayTeamName\": \"Coventry City FC\",\n" +
            "            \"awayTeamId\": 1076,\n" +
            "            \"result\": {\n" +
            "                \"goalsHomeTeam\": null,\n" +
            "                \"goalsAwayTeam\": null\n" +
            "            },\n" +
            "            \"odds\": null\n" +
            "        },\n" +
            "    ]\n" +
            "}";

    @Inject
    MockHelper() {
    }

    @Override
    public Observable<FixturesResponse> getMockFixtures() {
        return Observable.just(new Gson().fromJson(data, FixturesResponse.class));
    }

}
