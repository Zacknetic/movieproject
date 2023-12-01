package com.application.movieproject;

import com.application.movieproject.entity.*;
import com.application.movieproject.service.ActorService;
import com.application.movieproject.service.GenreService;
import com.application.movieproject.service.MovieService;
import com.application.movieproject.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class MovieprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieprojectApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate(MovieService movieService, GenreService genreService, ActorService actorService, PublisherService publisherService) {
        return (args) -> {
            // Define Genres
            Genre action = new Genre("Action");
            genreService.addGenre(action);
            Genre adventure = new Genre("Adventure");
            genreService.addGenre(adventure);
            Genre sciFi = new Genre("Sci-Fi");
            genreService.addGenre(sciFi);
            Genre comedy = new Genre("Comedy");
            genreService.addGenre(comedy);
            Genre drama = new Genre("Drama");
            genreService.addGenre(drama);
            Genre animation = new Genre("Animation");
            genreService.addGenre(animation);
            Genre family = new Genre("Family");
            genreService.addGenre(family);
            Genre fantasy = new Genre("Fantasy");
            genreService.addGenre(fantasy);
            Genre musical = new Genre("Musical");
            genreService.addGenre(musical);

            // Create and add actors to the actorService
            Actor jeffBridges = new Actor("Jeff Bridges", "An esteemed American actor known for his roles in 'The Big Lebowski,' 'Crazy Heart,' and 'Tron.' He has received numerous accolades including an Academy Award.");
            actorService.addActor(jeffBridges);
            Actor oliviaWilde = new Actor("Olivia Wilde", "An American actress and filmmaker. She gained fame for her role in the TV series 'House' and has directed critically acclaimed films like 'Booksmart.'");
            actorService.addActor(oliviaWilde);
            Actor kurtRussell = new Actor("Kurt Russell", "An American actor who has starred in a variety of film genres, known for his roles in 'Escape from New York,' 'The Thing,' and 'Guardians of the Galaxy Vol. 2.'");
            actorService.addActor(kurtRussell);
            Actor garrettHedlund = new Actor("Garrett Hedlund", "An American actor, model, and singer, known for his roles in 'Tron: Legacy,' 'Troy,' and 'Friday Night Lights.'");
            actorService.addActor(garrettHedlund);
            Actor jamesSpader = new Actor("James Spader", "An American actor known for his eccentric characters in films such as 'Sex, Lies, and Videotape,' and 'Stargate,' as well as the TV series 'The Blacklist.'");
            actorService.addActor(jamesSpader);
            Actor chrisPratt = new Actor("Chris Pratt", "An American actor who rose to fame with his role in 'Parks and Recreation' and has since become a leading figure in blockbusters like 'Guardians of the Galaxy' and 'Jurassic World.'");
            actorService.addActor(chrisPratt);
            Actor zoeSaldana = new Actor("Zoe Saldaña", "An American actress known for her roles in blockbuster films such as 'Avatar,' 'Star Trek,' and 'Guardians of the Galaxy.'");
            actorService.addActor(zoeSaldana);
            Actor dannyElfman = new Actor("Danny Elfman", "An American composer, singer, and songwriter, best known for his work scoring films and television, particularly his frequent collaborations with director Tim Burton.");
            actorService.addActor(dannyElfman);
            Actor chrisSarandon = new Actor("Chris Sarandon", "An American actor known for his role as Prince Humperdinck in 'The Princess Bride' and for providing the speaking voice of Jack Skellington in 'The Nightmare Before Christmas.'");
            actorService.addActor(chrisSarandon);
            Actor robertDowneyJr = new Actor("Robert Downey Jr.", "An American actor and producer, best known for his role as Iron Man in the Marvel Cinematic Universe, and his comeback story from personal struggles to one of Hollywood's top stars.");
            actorService.addActor(robertDowneyJr);
            Actor chrisEvans = new Actor("Chris Evans", "An American actor known for his portrayal of Captain America in the Marvel Cinematic Universe and for his roles in films like 'Fantastic Four' and 'Knives Out.'");
            actorService.addActor(chrisEvans);

            //Define Publishers
            Publisher marvelStudios = new Publisher("Marvel Studios");
            publisherService.addPublisher(marvelStudios);
            Publisher waltDisney = new Publisher("Walt Disney Pictures");
            publisherService.addPublisher(waltDisney);
            Publisher touchstonePictures = new Publisher("Touchstone Pictures");
            publisherService.addPublisher(touchstonePictures);
            Publisher metroGoldwynMayer = new Publisher("Metro-Goldwyn-Mayer");
            publisherService.addPublisher(metroGoldwynMayer);


            //Define Descriptions
            String tronLegacyDescription = "This sequel to a groundbreaking sci-fi film follows the story of a young man who is pulled into a digital world where his father has been trapped for years. Inside this visually stunning cyber universe, he embarks on a journey filled with dangerous programs and gladiatorial games, aiming to stop a malevolent dictator and save his father.";
            String stargateDescription = "An ancient, ring-shaped device is discovered in Egypt, leading to the revelation that it is a portal to other worlds. A team, including a linguist and a military unit, steps through the gateway and finds themselves on a distant planet with connections to ancient Egyptian culture and under the rule of a despotic alien.";
            String guardiansOfTheGalaxyDescription = "In this vibrant and action-packed space adventure, a group of intergalactic misfits, including a brash adventurer, a deadly assassin, a vengeance-driven warrior, a genetically-engineered raccoon, and a sentient tree-like creature, band together to stop a fanatical warrior from taking control of the universe.";
            String nightmareBeforeChristmasDescription = "This film is a unique stop-motion animated musical that tells the story of the king of Halloween Town who becomes enamored with the concept of Christmas. He attempts to bring Christmas to his world, leading to a peculiar and whimsical blending of holiday traditions and Halloween themes.";
            String avengersEndgameDescription = "This epic conclusion to a cinematic saga brings together superheroes from across the universe to undo the devastation caused by a powerful villain. In a desperate quest involving time travel and immense personal sacrifices, the heroes strive to restore balance and defeat the foe who threatens the existence of the entire universe.";

            // Movies with their respective genres and actors
            Movie tronLegacy = new Movie("Tron: Legacy", tronLegacyDescription);
            Link tronLink = new Link("https://www.imdb.com/title/tt1104001/");
            MetaData tronMetaData = new MetaData(125, LocalDate.of(2010, 12, 17), "English", new BigDecimal("170000000"), new BigDecimal("400062763"), "USA");
            tronLegacy.addActor(jeffBridges);
            tronLegacy.addActor(garrettHedlund);
            tronLegacy.addActor(oliviaWilde);
            tronLegacy.addGenre(action);
            tronLegacy.addGenre(adventure);
            tronLegacy.addGenre(sciFi);
            tronLegacy.addLink(tronLink);
            tronLegacy.setMetaData(tronMetaData);
            tronLegacy.addPublisher(waltDisney);
            movieService.addMovie(tronLegacy);

            Movie stargate = new Movie("Stargate", stargateDescription);
            Link stargateLink = new Link("https://www.imdb.com/title/tt0111282/");
            MetaData stargateMetaData = new MetaData(121, LocalDate.of(1994, 10, 28), "English", new BigDecimal("55000000"), new BigDecimal("196567262"), "USA");
            stargate.addActor(kurtRussell);
            stargate.addActor(jamesSpader);
            stargate.addGenre(action);
            stargate.addGenre(adventure);
            stargate.addGenre(sciFi);
            stargate.addLink(stargateLink);
            stargate.setMetaData(stargateMetaData);
            stargate.addPublisher(metroGoldwynMayer);
            movieService.addMovie(stargate);

            Movie guardiansOfTheGalaxy = new Movie("Guardians of the Galaxy", guardiansOfTheGalaxyDescription);
            Link gotgLink = new Link("https://www.imdb.com/title/tt2015381/");
            MetaData gotgMetaData = new MetaData(121, LocalDate.of(2014, 8, 1), "English", new BigDecimal("232300000"), new BigDecimal("770867516"), "USA");
            guardiansOfTheGalaxy.addActor(chrisPratt);
            guardiansOfTheGalaxy.addActor(zoeSaldana);
            guardiansOfTheGalaxy.addGenre(action);
            guardiansOfTheGalaxy.addGenre(adventure);
            guardiansOfTheGalaxy.addGenre(comedy);
            guardiansOfTheGalaxy.addLink(gotgLink);
            guardiansOfTheGalaxy.setMetaData(gotgMetaData);
            guardiansOfTheGalaxy.addPublisher(marvelStudios);
            movieService.addMovie(guardiansOfTheGalaxy);

            Movie nightmareBeforeChristmas = new Movie("The Nightmare Before Christmas", nightmareBeforeChristmasDescription);
            Link nightmareLink = new Link("https://www.imdb.com/title/tt0107688/");
            MetaData nightmareMetaData = new MetaData(76, LocalDate.of(1993, 10, 29), "English", new BigDecimal("18000000"), new BigDecimal("91600000"), "USA");
            nightmareBeforeChristmas.addActor(dannyElfman);
            nightmareBeforeChristmas.addActor(chrisSarandon);
            nightmareBeforeChristmas.addGenre(animation);
            nightmareBeforeChristmas.addGenre(family);
            nightmareBeforeChristmas.addGenre(fantasy);
            nightmareBeforeChristmas.addGenre(musical);
            nightmareBeforeChristmas.addLink(nightmareLink);
            nightmareBeforeChristmas.setMetaData(nightmareMetaData);
            nightmareBeforeChristmas.addPublisher(touchstonePictures);
            movieService.addMovie(nightmareBeforeChristmas);

            Movie avengersEndgame = new Movie("Avengers: Endgame", avengersEndgameDescription);
            Link avengersLink = new Link("https://www.imdb.com/title/tt4154796/");
            MetaData avengersMetaData = new MetaData(181, LocalDate.of(2019, 4, 26), "English", new BigDecimal("356000000"), new BigDecimal("2797800564"), "USA");
            avengersEndgame.addActor(robertDowneyJr);
            avengersEndgame.addActor(chrisEvans);
            avengersEndgame.addActor(chrisPratt);
            avengersEndgame.addActor(zoeSaldana);
            avengersEndgame.addGenre(action);
            avengersEndgame.addGenre(adventure);
            avengersEndgame.addGenre(drama);
            avengersEndgame.addGenre(sciFi);
            avengersEndgame.addLink(avengersLink);
            avengersEndgame.setMetaData(avengersMetaData);
            avengersEndgame.addPublisher(marvelStudios);
            movieService.addMovie(avengersEndgame);
        };
    }
}
