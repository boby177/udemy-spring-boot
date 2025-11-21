package com.bob.cruddemo;

import com.bob.cruddemo.dao.AppDAO;
import com.bob.cruddemo.entity.Instructor;
import com.bob.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInsructor(appDAO);
            // findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Instructor Deleted!");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInsructor(AppDAO appDAO) {

        /*
        // create the instructor
        Instructor tempInstructor = new Instructor("Boby", "Maulana", "boby.ms378@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.youtube.com/bob.gamings",
                "Video Game");
         */

        // create the instructor
        Instructor tempInstructor = new Instructor("Sakura", "Rara", "saku.rara@gmail.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.youtube.com/saku.rara",
                "Gardening");

        // associate the object 1 to 1 relationship
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done");
    }
}
