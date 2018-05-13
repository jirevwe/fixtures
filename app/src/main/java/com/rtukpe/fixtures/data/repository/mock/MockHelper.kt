package com.rtukpe.fixtures.data.repository.mock

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rtukpe.fixtures.data.model.*
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class MockHelper @Inject
internal constructor() : MockerInterface {

    private var fixtures: String
    private val teams: String
    private val competitions: String
    private val table: String
    private val players: String

    init {
        players = "{\n" +
                "    \"count\": 27,\n" +
                "    \"players\": [\n" +
                "        {\n" +
                "            \"id\": 237,\n" +
                "            \"name\": \"Romelu Lukaku\",\n" +
                "            \"position\": \"Centre-Forward\",\n" +
                "            \"jerseyNumber\": 9,\n" +
                "            \"dateOfBirth\": \"1993-05-13\",\n" +
                "            \"nationality\": \"Belgium\",\n" +
                "            \"contractUntil\": \"2022-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 439,\n" +
                "            \"name\": \"David de Gea\",\n" +
                "            \"position\": \"Keeper\",\n" +
                "            \"jerseyNumber\": 1,\n" +
                "            \"dateOfBirth\": \"1990-11-07\",\n" +
                "            \"nationality\": \"Spain\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 440,\n" +
                "            \"name\": \"Sergio Romero\",\n" +
                "            \"position\": \"Keeper\",\n" +
                "            \"jerseyNumber\": 20,\n" +
                "            \"dateOfBirth\": \"1987-02-22\",\n" +
                "            \"nationality\": \"Argentina\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 441,\n" +
                "            \"name\": \"Eric Bailly\",\n" +
                "            \"position\": \"Centre-Back\",\n" +
                "            \"jerseyNumber\": 3,\n" +
                "            \"dateOfBirth\": \"1994-04-12\",\n" +
                "            \"nationality\": \"Cote d'Ivoire\",\n" +
                "            \"contractUntil\": \"2020-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 442,\n" +
                "            \"name\": \"Chris Smalling\",\n" +
                "            \"position\": \"Centre-Back\",\n" +
                "            \"jerseyNumber\": 12,\n" +
                "            \"dateOfBirth\": \"1989-11-22\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 443,\n" +
                "            \"name\": \"Marcos Rojo\",\n" +
                "            \"position\": \"Centre-Back\",\n" +
                "            \"jerseyNumber\": 5,\n" +
                "            \"dateOfBirth\": \"1990-03-20\",\n" +
                "            \"nationality\": \"Argentina\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 444,\n" +
                "            \"name\": \"Phil Jones\",\n" +
                "            \"position\": \"Centre-Back\",\n" +
                "            \"jerseyNumber\": 4,\n" +
                "            \"dateOfBirth\": \"1992-02-21\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 445,\n" +
                "            \"name\": \"Daley Blind\",\n" +
                "            \"position\": \"Left-Back\",\n" +
                "            \"jerseyNumber\": 17,\n" +
                "            \"dateOfBirth\": \"1990-03-09\",\n" +
                "            \"nationality\": \"Netherlands\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 446,\n" +
                "            \"name\": \"Luke Shaw\",\n" +
                "            \"position\": \"Left-Back\",\n" +
                "            \"jerseyNumber\": 23,\n" +
                "            \"dateOfBirth\": \"1995-07-12\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2018-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 447,\n" +
                "            \"name\": \"Matteo Darmian\",\n" +
                "            \"position\": \"Right-Back\",\n" +
                "            \"jerseyNumber\": 36,\n" +
                "            \"dateOfBirth\": \"1989-12-02\",\n" +
                "            \"nationality\": \"Italy\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 448,\n" +
                "            \"name\": \"Antonio Valencia\",\n" +
                "            \"position\": \"Right-Back\",\n" +
                "            \"jerseyNumber\": 25,\n" +
                "            \"dateOfBirth\": \"1985-08-04\",\n" +
                "            \"nationality\": \"Ecuador\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 449,\n" +
                "            \"name\": \"Michael Carrick\",\n" +
                "            \"position\": \"Defensive Midfield\",\n" +
                "            \"jerseyNumber\": 16,\n" +
                "            \"dateOfBirth\": \"1981-07-28\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2018-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 451,\n" +
                "            \"name\": \"Paul Pogba\",\n" +
                "            \"position\": \"Central Midfield\",\n" +
                "            \"jerseyNumber\": 6,\n" +
                "            \"dateOfBirth\": \"1993-03-15\",\n" +
                "            \"nationality\": \"France\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 452,\n" +
                "            \"name\": \"Ander Herrera\",\n" +
                "            \"position\": \"Central Midfield\",\n" +
                "            \"jerseyNumber\": 21,\n" +
                "            \"dateOfBirth\": \"1989-08-14\",\n" +
                "            \"nationality\": \"Spain\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 453,\n" +
                "            \"name\": \"Marouane Fellaini\",\n" +
                "            \"position\": \"Central Midfield\",\n" +
                "            \"jerseyNumber\": 27,\n" +
                "            \"dateOfBirth\": \"1987-11-22\",\n" +
                "            \"nationality\": \"Belgium\",\n" +
                "            \"contractUntil\": \"2018-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 454,\n" +
                "            \"name\": \"Ashley Young\",\n" +
                "            \"position\": \"Left Midfield\",\n" +
                "            \"jerseyNumber\": 18,\n" +
                "            \"dateOfBirth\": \"1985-07-09\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2018-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 456,\n" +
                "            \"name\": \"Juan Mata\",\n" +
                "            \"position\": \"Attacking Midfield\",\n" +
                "            \"jerseyNumber\": 8,\n" +
                "            \"dateOfBirth\": \"1988-04-28\",\n" +
                "            \"nationality\": \"Spain\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 457,\n" +
                "            \"name\": \"Jesse Lingard\",\n" +
                "            \"position\": \"Left Wing\",\n" +
                "            \"jerseyNumber\": 14,\n" +
                "            \"dateOfBirth\": \"1992-12-15\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 459,\n" +
                "            \"name\": \"Anthony Martial\",\n" +
                "            \"position\": \"Left Wing\",\n" +
                "            \"jerseyNumber\": 11,\n" +
                "            \"dateOfBirth\": \"1995-12-05\",\n" +
                "            \"nationality\": \"France\",\n" +
                "            \"contractUntil\": \"2019-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 460,\n" +
                "            \"name\": \"Zlatan Ibrahimovic\",\n" +
                "            \"position\": \"Centre-Forward\",\n" +
                "            \"jerseyNumber\": 10,\n" +
                "            \"dateOfBirth\": \"1981-10-03\",\n" +
                "            \"nationality\": \"Sweden\",\n" +
                "            \"contractUntil\": \"2018-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 461,\n" +
                "            \"name\": \"Marcus Rashford\",\n" +
                "            \"position\": \"Centre-Forward\",\n" +
                "            \"jerseyNumber\": 19,\n" +
                "            \"dateOfBirth\": \"1997-10-31\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2020-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 484,\n" +
                "            \"name\": \"Alexis Sánchez\",\n" +
                "            \"position\": \"Left Wing\",\n" +
                "            \"jerseyNumber\": 7,\n" +
                "            \"dateOfBirth\": \"1988-12-19\",\n" +
                "            \"nationality\": \"Chile\",\n" +
                "            \"contractUntil\": \"2022-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 533,\n" +
                "            \"name\": \"Nemanja Matic\",\n" +
                "            \"position\": \"Defensive Midfield\",\n" +
                "            \"jerseyNumber\": 31,\n" +
                "            \"dateOfBirth\": \"1988-08-01\",\n" +
                "            \"nationality\": \"Serbia\",\n" +
                "            \"contractUntil\": \"2020-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3936,\n" +
                "            \"name\": \"Victor Lindelöf\",\n" +
                "            \"position\": \"Centre-Back\",\n" +
                "            \"jerseyNumber\": 2,\n" +
                "            \"dateOfBirth\": \"1994-07-17\",\n" +
                "            \"nationality\": \"Sweden\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4212,\n" +
                "            \"name\": \"Joel Pereira\",\n" +
                "            \"position\": \"Keeper\",\n" +
                "            \"jerseyNumber\": 40,\n" +
                "            \"dateOfBirth\": \"1996-06-28\",\n" +
                "            \"nationality\": \"Portugal\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5373,\n" +
                "            \"name\": \"Cameron Borthwick-Jackson\",\n" +
                "            \"position\": \"Left-Back\",\n" +
                "            \"jerseyNumber\": 43,\n" +
                "            \"dateOfBirth\": \"1997-02-02\",\n" +
                "            \"nationality\": \"England\",\n" +
                "            \"contractUntil\": \"2020-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5374,\n" +
                "            \"name\": \"Scott McTominay\",\n" +
                "            \"position\": \"Attacking Midfield\",\n" +
                "            \"jerseyNumber\": 39,\n" +
                "            \"dateOfBirth\": \"1996-12-08\",\n" +
                "            \"nationality\": \"Scotland\",\n" +
                "            \"contractUntil\": \"2021-06-30\",\n" +
                "            \"marketValue\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}"
    }

    init {
        table = "{\n" +
                "    \"leagueCaption\": \"Ligue 2 2017/18\",\n" +
                "    \"matchday\": 36,\n" +
                "    \"standing\": [\n" +
                "        {\n" +
                "            \"rank\": 1,\n" +
                "            \"team\": \"Reims\",\n" +
                "            \"teamId\": 547,\n" +
                "            \"playedGames\": 35,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/9/9e/Stade_Reims_Logo.svg\",\n" +
                "            \"points\": 84,\n" +
                "            \"goals\": 69,\n" +
                "            \"goalsAgainst\": 20,\n" +
                "            \"goalDifference\": 49\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 2,\n" +
                "            \"team\": \"Nîmes\",\n" +
                "            \"teamId\": 556,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/b/b6/Olympique_Nimes.svg\",\n" +
                "            \"points\": 69,\n" +
                "            \"goals\": 69,\n" +
                "            \"goalsAgainst\": 35,\n" +
                "            \"goalDifference\": 34\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 3,\n" +
                "            \"team\": \"Ajaccio\",\n" +
                "            \"teamId\": 510,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/5/58/AC_Ajaccio.svg\",\n" +
                "            \"points\": 66,\n" +
                "            \"goals\": 59,\n" +
                "            \"goalsAgainst\": 40,\n" +
                "            \"goalDifference\": 19\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 4,\n" +
                "            \"team\": \"Brest\",\n" +
                "            \"teamId\": 512,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/c/cb/Stade_Brestois_29.svg\",\n" +
                "            \"points\": 61,\n" +
                "            \"goals\": 54,\n" +
                "            \"goalsAgainst\": 41,\n" +
                "            \"goalDifference\": 13\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 5,\n" +
                "            \"team\": \"Clermont\",\n" +
                "            \"teamId\": 541,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/a/a1/Clermont_Foot_Auvergne.svg\",\n" +
                "            \"points\": 59,\n" +
                "            \"goals\": 49,\n" +
                "            \"goalsAgainst\": 33,\n" +
                "            \"goalDifference\": 16\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 6,\n" +
                "            \"team\": \"Lorient\",\n" +
                "            \"teamId\": 525,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/c/c4/FC_Lorient_neu.png\",\n" +
                "            \"points\": 59,\n" +
                "            \"goals\": 55,\n" +
                "            \"goalsAgainst\": 43,\n" +
                "            \"goalDifference\": 12\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 7,\n" +
                "            \"team\": \"Châteauroux\",\n" +
                "            \"teamId\": 539,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/4/42/La_Berrichonne_de_Ch%C3%A2teauroux.svg\",\n" +
                "            \"points\": 58,\n" +
                "            \"goals\": 47,\n" +
                "            \"goalsAgainst\": 47,\n" +
                "            \"goalDifference\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 8,\n" +
                "            \"team\": \"Le HAC\",\n" +
                "            \"teamId\": 533,\n" +
                "            \"playedGames\": 35,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/4/47/Le_Havre_AC.svg\",\n" +
                "            \"points\": 57,\n" +
                "            \"goals\": 49,\n" +
                "            \"goalsAgainst\": 34,\n" +
                "            \"goalDifference\": 15\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 9,\n" +
                "            \"team\": \"Paris\",\n" +
                "            \"teamId\": 1045,\n" +
                "            \"playedGames\": 35,\n" +
                "            \"crestURI\": \"https://upload.wikimedia.org/wikipedia/de/b/be/Logo_ParisFC_2011.png\",\n" +
                "            \"points\": 57,\n" +
                "            \"goals\": 42,\n" +
                "            \"goalsAgainst\": 32,\n" +
                "            \"goalDifference\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 10,\n" +
                "            \"team\": \"Sochaux\",\n" +
                "            \"teamId\": 517,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/a/ae/FC_Sochaux_Logo_2010.svg\",\n" +
                "            \"points\": 53,\n" +
                "            \"goals\": 49,\n" +
                "            \"goalsAgainst\": 57,\n" +
                "            \"goalDifference\": -8\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 11,\n" +
                "            \"team\": \"Auxerre\",\n" +
                "            \"teamId\": 519,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/5/5b/AJ_Auxerre.svg\",\n" +
                "            \"points\": 46,\n" +
                "            \"goals\": 49,\n" +
                "            \"goalsAgainst\": 52,\n" +
                "            \"goalDifference\": -3\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 12,\n" +
                "            \"team\": \"Orleans\",\n" +
                "            \"teamId\": 742,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/fr/thumb/2/2b/Union_sportive_Orl%C3%A9ans_Loiret_football_2.jpg/200px-Union_sportive_Orl%C3%A9ans_Loiret_football_2.jpg\",\n" +
                "            \"points\": 45,\n" +
                "            \"goals\": 51,\n" +
                "            \"goalsAgainst\": 57,\n" +
                "            \"goalDifference\": -6\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 13,\n" +
                "            \"team\": \"Valenciennes\",\n" +
                "            \"teamId\": 515,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/e/eb/Valenciennes_AFC_%282008%29.svg\",\n" +
                "            \"points\": 42,\n" +
                "            \"goals\": 45,\n" +
                "            \"goalsAgainst\": 58,\n" +
                "            \"goalDifference\": -13\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 14,\n" +
                "            \"team\": \"Niort\",\n" +
                "            \"teamId\": 557,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/0/0a/Chamois_Niort_Logo.svg\",\n" +
                "            \"points\": 41,\n" +
                "            \"goals\": 45,\n" +
                "            \"goalsAgainst\": 57,\n" +
                "            \"goalDifference\": -12\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 15,\n" +
                "            \"team\": \"Ajaccio\",\n" +
                "            \"teamId\": 555,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/en/4/46/Gaz%C3%A9lec_Ajaccio_logo.png\",\n" +
                "            \"points\": 41,\n" +
                "            \"goals\": 32,\n" +
                "            \"goalsAgainst\": 52,\n" +
                "            \"goalDifference\": -20\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 16,\n" +
                "            \"team\": \"Lens\",\n" +
                "            \"teamId\": 546,\n" +
                "            \"playedGames\": 35,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/d/d7/RC_Lens_Logo.svg\",\n" +
                "            \"points\": 37,\n" +
                "            \"goals\": 43,\n" +
                "            \"goalsAgainst\": 44,\n" +
                "            \"goalDifference\": -1\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 17,\n" +
                "            \"team\": \"Nancy\",\n" +
                "            \"teamId\": 520,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/8/8f/AS_Nancy_Logo.svg\",\n" +
                "            \"points\": 35,\n" +
                "            \"goals\": 35,\n" +
                "            \"goalsAgainst\": 52,\n" +
                "            \"goalDifference\": -17\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 18,\n" +
                "            \"team\": \"FC Bourg-Péronnas\",\n" +
                "            \"teamId\": 1042,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"https://upload.wikimedia.org/wikipedia/fr/6/66/Football_Bourg_en_Bresse_P%C3%A9ronnas_logo.png\",\n" +
                "            \"points\": 33,\n" +
                "            \"goals\": 48,\n" +
                "            \"goalsAgainst\": 80,\n" +
                "            \"goalDifference\": -32\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 19,\n" +
                "            \"team\": null,\n" +
                "            \"teamId\": 1807,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": null,\n" +
                "            \"points\": 30,\n" +
                "            \"goals\": 42,\n" +
                "            \"goalsAgainst\": 64,\n" +
                "            \"goalDifference\": -22\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": 20,\n" +
                "            \"team\": \"Tours\",\n" +
                "            \"teamId\": 544,\n" +
                "            \"playedGames\": 36,\n" +
                "            \"crestURI\": \"http://upload.wikimedia.org/wikipedia/de/9/9a/FC_Tours.svg\",\n" +
                "            \"points\": 20,\n" +
                "            \"goals\": 30,\n" +
                "            \"goalsAgainst\": 64,\n" +
                "            \"goalDifference\": -34\n" +
                "        }\n" +
                "    ]\n" +
                "}"
    }

    init {
        fixtures = "{\"timeFrameStart\":\"2018-04-24\",\"timeFrameEnd\":\"2018-04-25\",\"count\":20,\"fixtures\":[{\"id\":161698,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Stade Brestois\",\"homeTeamId\":512,\"awayTeamName\":\"Clermont Foot Auvergne\",\"awayTeamId\":541,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":162013,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"RC Tours\",\"homeTeamId\":544,\"awayTeamName\":\"Quevilly Rouen\",\"awayTeamId\":1807,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161701,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Chamois Niortais FC\",\"homeTeamId\":557,\"awayTeamName\":\"Gazélec Ajaccio\",\"awayTeamId\":555,\"result\":{\"goalsHomeTeam\":4,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161695,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Ajaccio AC\",\"homeTeamId\":510,\"awayTeamName\":\"RC Lens\",\"awayTeamId\":546,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161696,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"AJ Auxerre\",\"homeTeamId\":519,\"awayTeamName\":\"Stade de Reims\",\"awayTeamId\":547,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":4,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161697,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"IN_PLAY\",\"matchday\":35,\"homeTeamName\":\"Paris FC\",\"homeTeamId\":1045,\"awayTeamName\":\"LB Châteauroux\",\"awayTeamId\":539,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0},\"odds\":null},{\"id\":161699,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Le Havre AC\",\"homeTeamId\":533,\"awayTeamName\":\"AS Nancy\",\"awayTeamId\":520,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161700,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Nîmes Olympique\",\"homeTeamId\":556,\"awayTeamName\":\"FC Lorient\",\"awayTeamId\":525,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":161702,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"US Orleans\",\"homeTeamId\":742,\"awayTeamName\":\"FC Bourg-en-Bresse Péronnas\",\"awayTeamId\":1042,\"result\":{\"goalsHomeTeam\":5,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":161703,\"competitionId\":451,\"date\":\"2018-04-24T18:00:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"FC Valenciennes\",\"homeTeamId\":515,\"awayTeamName\":\"Sochaux FC\",\"awayTeamId\":517,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":159427,\"competitionId\":446,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":38,\"homeTeamName\":\"Derby County\",\"homeTeamId\":342,\"awayTeamName\":\"Cardiff City FC\",\"awayTeamId\":715,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":160015,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":35,\"homeTeamName\":\"Oldham Athletic AFC\",\"homeTeamId\":1075,\"awayTeamName\":\"Southend United FC\",\"awayTeamId\":1069,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":3,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":160107,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":27,\"homeTeamName\":\"Bristol Rovers\",\"homeTeamId\":400,\"awayTeamName\":\"Wigan Athletic FC\",\"awayTeamId\":75,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160008,\"compet\n" + "itionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Shrewsbury Town FC\",\"homeTeamId\":1080,\"awayTeamName\":\"Peterborough United FC\",\"awayTeamId\":1077,\"result\":{\"goalsHomeTeam\":3,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1}},\"odds\":null},{\"id\":159988,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":37,\"homeTeamName\":\"Bradford City AFC\",\"homeTeamId\":1067,\"awayTeamName\":\"Milton Keynes Dons\",\"awayTeamId\":409,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":159965,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":39,\"homeTeamName\":\"Doncaster Rovers FC\",\"homeTeamId\":1071,\"awayTeamName\":\"Blackburn Rovers FC\",\"awayTeamId\":59,\"result\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160006,\"competitionId\":447,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Rochdale AFC\",\"homeTeamId\":361,\"awayTeamName\":\"Plymouth Argyle\",\"awayTeamId\":1138,\"result\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":0,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160559,\"competitionId\":448,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Newport County\",\"homeTeamId\":1142,\"awayTeamName\":\"Accrington Stanley\",\"awayTeamId\":1145,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":1,\"halfTime\":{\"goalsHomeTeam\":1,\"goalsAwayTeam\":0}},\"odds\":null},{\"id\":160554,\"competitionId\":448,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":36,\"homeTeamName\":\"Coventry City FC\",\"homeTeamId\":1076,\"awayTeamName\":\"Lincoln City\",\"awayTeamId\":1126,\"result\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":4,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":3}},\"odds\":null},{\"id\":166840,\"competitionId\":464,\"date\":\"2018-04-24T18:45:00Z\",\"status\":\"FINISHED\",\"matchday\":9,\"homeTeamName\":\"Liverpool FC\",\"homeTeamId\":64,\"awayTeamName\":\"AS Roma\",\"awayTeamId\":100,\"result\":{\"goalsHomeTeam\":5,\"goalsAwayTeam\":2,\"halfTime\":{\"goalsHomeTeam\":2,\"goalsAwayTeam\":0}},\"odds\":null}]}"
    }

    init {
        teams = "{\n" +
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
                "}"
    }

    init {
        competitions = "[\n" +
                "    {\n" +
                "        \"id\": 444,\n" +
                "        \"caption\": \"Campeonato Brasileiro da Série A\",\n" +
                "        \"league\": \"BSA\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 38,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2017-12-11T07:05:27Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 445,\n" +
                "        \"caption\": \"Premier League 2017/18\",\n" +
                "        \"league\": \"PL\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 36,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:08Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 446,\n" +
                "        \"caption\": \"Championship 2017/18\",\n" +
                "        \"league\": \"ELC\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 45,\n" +
                "        \"numberOfMatchdays\": 46,\n" +
                "        \"numberOfTeams\": 24,\n" +
                "        \"numberOfGames\": 552,\n" +
                "        \"lastUpdated\": \"2018-04-27T04:00:05Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 447,\n" +
                "        \"caption\": \"League One 2017/18\",\n" +
                "        \"league\": \"EL1\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 45,\n" +
                "        \"numberOfMatchdays\": 46,\n" +
                "        \"numberOfTeams\": 24,\n" +
                "        \"numberOfGames\": 552,\n" +
                "        \"lastUpdated\": \"2018-04-27T04:00:06Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 448,\n" +
                "        \"caption\": \"League Two 2017/18\",\n" +
                "        \"league\": \"EL2\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 45,\n" +
                "        \"numberOfMatchdays\": 46,\n" +
                "        \"numberOfTeams\": 24,\n" +
                "        \"numberOfGames\": 552,\n" +
                "        \"lastUpdated\": \"2018-04-27T04:00:07Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 449,\n" +
                "        \"caption\": \"Eredivisie 2017/18\",\n" +
                "        \"league\": \"DED\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 33,\n" +
                "        \"numberOfMatchdays\": 34,\n" +
                "        \"numberOfTeams\": 18,\n" +
                "        \"numberOfGames\": 306,\n" +
                "        \"lastUpdated\": \"2018-04-22T10:00:09Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 450,\n" +
                "        \"caption\": \"Ligue 1 2017/18\",\n" +
                "        \"league\": \"FL1\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 35,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:13Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 451,\n" +
                "        \"caption\": \"Ligue 2 2017/18\",\n" +
                "        \"league\": \"FL2\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 36,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:16Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 452,\n" +
                "        \"caption\": \"1. Bundesliga 2017/18\",\n" +
                "        \"league\": \"BL1\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 32,\n" +
                "        \"numberOfMatchdays\": 34,\n" +
                "        \"numberOfTeams\": 18,\n" +
                "        \"numberOfGames\": 306,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:20Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 453,\n" +
                "        \"caption\": \"2. Bundesliga 2017/18\",\n" +
                "        \"league\": \"BL2\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 32,\n" +
                "        \"numberOfMatchdays\": 34,\n" +
                "        \"numberOfTeams\": 18,\n" +
                "        \"numberOfGames\": 306,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:22Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 455,\n" +
                "        \"caption\": \"Primera Division 2017\",\n" +
                "        \"league\": \"PD\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 35,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2018-04-29T12:20:26Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 456,\n" +
                "        \"caption\": \"Serie A 2017/18\",\n" +
                "        \"league\": \"SA\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 35,\n" +
                "        \"numberOfMatchdays\": 38,\n" +
                "        \"numberOfTeams\": 20,\n" +
                "        \"numberOfGames\": 380,\n" +
                "        \"lastUpdated\": \"2018-04-26T10:00:13Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 457,\n" +
                "        \"caption\": \"Primeira Liga 2017/18\",\n" +
                "        \"league\": \"PPL\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 32,\n" +
                "        \"numberOfMatchdays\": 34,\n" +
                "        \"numberOfTeams\": 18,\n" +
                "        \"numberOfGames\": 306,\n" +
                "        \"lastUpdated\": \"2018-04-26T10:00:14Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 458,\n" +
                "        \"caption\": \"DFB-Pokal 2017/18\",\n" +
                "        \"league\": \"DFB\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 6,\n" +
                "        \"numberOfMatchdays\": 6,\n" +
                "        \"numberOfTeams\": 64,\n" +
                "        \"numberOfGames\": 63,\n" +
                "        \"lastUpdated\": \"2018-04-20T10:00:18Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 459,\n" +
                "        \"caption\": \"Serie B 2017/18\",\n" +
                "        \"league\": \"SB\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 38,\n" +
                "        \"numberOfMatchdays\": 42,\n" +
                "        \"numberOfTeams\": 22,\n" +
                "        \"numberOfGames\": 462,\n" +
                "        \"lastUpdated\": \"2018-04-26T10:00:16Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 464,\n" +
                "        \"caption\": \"Champions League 2017/18\",\n" +
                "        \"league\": \"CL\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 9,\n" +
                "        \"numberOfMatchdays\": 10,\n" +
                "        \"numberOfTeams\": 32,\n" +
                "        \"numberOfGames\": 124,\n" +
                "        \"lastUpdated\": \"2018-04-25T20:50:00Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 466,\n" +
                "        \"caption\": \"Australian A-League\",\n" +
                "        \"league\": \"AAL\",\n" +
                "        \"year\": \"2017\",\n" +
                "        \"currentMatchday\": 27,\n" +
                "        \"numberOfMatchdays\": 27,\n" +
                "        \"numberOfTeams\": 10,\n" +
                "        \"numberOfGames\": 135,\n" +
                "        \"lastUpdated\": \"2018-04-15T09:10:00Z\"\n" +
                "    }\n" +
                "]"
    }

    override val mockTeamPlayers: PlayersResponse
        get() = Gson().fromJson(players, PlayersResponse::class.java)

    override val mockCompetitionTable: Observable<LeagueTable>
        get() = Observable.just(Gson().fromJson(table, LeagueTable::class.java))

    override val mockTeams: Observable<TeamsResponse>
        get() = Observable.just(Gson().fromJson(teams, TeamsResponse::class.java))

    override val mockCompetitions: Observable<ArrayList<Competition>>
        get() = mockCompetitions()

    override fun getMockFixtures(timeFrameStart: String, timeFrameEnd: String): Observable<FixturesResponse> {
        return Observable.just(Gson().fromJson(fixtures, FixturesResponse::class.java))
    }

    fun mockCompetitions(): Observable<ArrayList<Competition>> {
        val type = object : TypeToken<ArrayList<Competition>>() {}.type
        return Observable.just<ArrayList<Competition>>(Gson().fromJson(competitions, type))
    }
}
