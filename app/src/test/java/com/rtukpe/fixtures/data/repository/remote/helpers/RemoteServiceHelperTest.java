package com.rtukpe.fixtures.data.repository.remote.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rtukpe.fixtures.data.model.Competition;
import com.rtukpe.fixtures.data.model.PlayersResponse;
import com.rtukpe.fixtures.data.model.TeamsResponse;
import com.rtukpe.fixtures.data.repository.remote.api.RemoteServiceApi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RemoteServiceHelperTest {

    private final String FIRST_COMPETITION_CAPTION = "Campeonato Brasileiro da Série A";
    private final String SECOND_COMPETITION_YEAR = "2017";

    private final String FIRST_TEAM_NAME = "US Orleans";
    private final String SECOND_TEAM_URL = "http://upload.wikimedia.org/wikipedia/de/d/d7/RC_Lens_Logo.svg";

    private final String FIRST_PLAYER_NAME = "David de Gea";
    private final String SECOND_PLAYER_NATIONALITY = "England";

    private final int COMPETITION_ID = 424;
    private final int TEAM_ID = 424;

    @Mock
    RemoteServiceApi remoteServiceApi;
    String competitions, teams, players;
    private RemoteServiceHelper remoteServiceHelper;

    {
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
                "]";
    }

    {
        teams = "{\n" +
                "    \"count\": 4,\n" +
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
                "            \"id\": 546,\n" +
                "            \"name\": \"RC Lens\",\n" +
                "            \"shortName\": \"Lens\",\n" +
                "            \"squadMarketValue\": null,\n" +
                "            \"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/d/d7/RC_Lens_Logo.svg\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    {
        players = "{\n" +
                "    \"count\": 5,\n" +
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
                "    ]\n" +
                "}";
    }

    private ArrayList<Competition> getCompetitions() {
        Type type = new TypeToken<ArrayList<Competition>>() {
        }.getType();
        return new Gson().fromJson(competitions, type);
    }

    private TeamsResponse getTeams() {
        return new Gson().fromJson(teams, TeamsResponse.class);
    }

    private PlayersResponse getPlayers() {
        return new Gson().fromJson(players, PlayersResponse.class);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        remoteServiceHelper = new RemoteServiceHelper();
        remoteServiceHelper.setRemoteServiceApi(remoteServiceApi);
    }

    @Test
    public void getCompetitions_200_OK_Response_InvokesCorrectApiCall() {
        //Given
        when(remoteServiceApi.getCompetitions()).thenReturn(Observable.just(getCompetitions()));

        //When
        TestObserver<ArrayList<Competition>> observer = new TestObserver<>();
        remoteServiceHelper.getCompetitions().subscribe(observer);

        //Then
        observer.awaitTerminalEvent();
        observer.assertNoErrors();

        List<ArrayList<Competition>> onNextEvents = observer.values();
        ArrayList<Competition> firstCompetition = onNextEvents.get(0);

        Assert.assertEquals(FIRST_COMPETITION_CAPTION, firstCompetition.get(0).getCaption());
        Assert.assertEquals(SECOND_COMPETITION_YEAR, firstCompetition.get(1).getYear());
        verify(remoteServiceApi).getCompetitions();
    }

    @Test
    public void getCompetitionTeams_200_OK_Response_InvokesCorrectApiCall() {
        //Given
        when(remoteServiceApi.getCompetitionTeams(COMPETITION_ID)).thenReturn(Observable.just(getTeams()));

        //When
        TestObserver<TeamsResponse> observer = new TestObserver<>();
        remoteServiceHelper.getCompetitionTeams(COMPETITION_ID).subscribe(observer);

        //Then
        observer.awaitTerminalEvent();
        observer.assertNoErrors();

        List<TeamsResponse> onNextEvents = observer.values();
        TeamsResponse firstResponse = onNextEvents.get(0);

        Assert.assertEquals(FIRST_TEAM_NAME, firstResponse.teams.get(0).name);
        Assert.assertEquals(SECOND_TEAM_URL, firstResponse.teams.get(3).logo);
        Assert.assertEquals(firstResponse.count, firstResponse.teams.size());
        verify(remoteServiceApi).getCompetitionTeams(COMPETITION_ID);
    }

    @Test
    public void getPlayers_200_OK_Response_InvokesCorrectApiCall() {
        //Given
        when(remoteServiceApi.getTeamPlayers(COMPETITION_ID)).thenReturn(Observable.just(getPlayers()));

        //When
        TestObserver<PlayersResponse> observer = new TestObserver<>();
        remoteServiceHelper.getTeamPlayers(COMPETITION_ID).subscribe(observer);

        //Then
        observer.awaitTerminalEvent();
        observer.assertNoErrors();

        List<PlayersResponse> onNextEvents = observer.values();
        PlayersResponse firstResponse = onNextEvents.get(0);

        Assert.assertEquals(FIRST_PLAYER_NAME, firstResponse.players.get(1).name);
        Assert.assertEquals(SECOND_PLAYER_NATIONALITY, firstResponse.players.get(4).nationality);
        verify(remoteServiceApi).getTeamPlayers(COMPETITION_ID);
    }
}