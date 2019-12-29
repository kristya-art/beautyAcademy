package org.bea.ServiceTests;

import org.bea.bea.model.Course;
import org.bea.bea.model.Participant;
import org.bea.bea.model.Subscription;
import org.bea.bea.service.CourseService;
import org.bea.bea.service.SubscriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Autowired
    SubscriptionService subscriptionService;

    @Test
    public void saveCourse() {


    Collection<Participant> collection = new HashSet<>();

    Course course = new Course("4536", "Beauty-course", "beauty", 45);
    courseService.saveCourse(course);
    assertThat(course.getId()).isNotNull();
    Date date = new Date(2020 / 11 / 3);
    Date date2 = new Date(2020 / 11 / 17);

//    Subscription subscription = new Subscription(collection, course, date, date2);
//
//    subscriptionService.saveSubscription(subscription);
//    assertThat(subscription.getCourse()).isEqualTo(course);


}

   @Test
    public void deleteCourse()throws Exception{
       Course course2 = new Course("4537", "M-course", "beauty", 45);
       courseService.saveCourse(course2);
        //Long id = course2.getId();
        courseService.deleteCourse(course2.getId());

        //assertThat(course2.getId()).isNull();
        //System.out.println(course2);
      //  assertThat(courseService.findCourse(course2.getId()));

   }


}
