package com.example.demo_sprimg;

import com.example.demo_sprimg.dao.ClassRoomDAO;
import com.example.demo_sprimg.entity.ClassRoom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSprimgApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSprimgApplication.class, args);
		System.out.println("test");
	}

	@Bean
	public static CommandLineRunner commandLineRunner(ClassRoomDAO classRoomDAO){
		return args -> {
			System.out.println("start...");
			getClassById(classRoomDAO);
			addNewClass(classRoomDAO);

		};
	}

	private static void addNewClass(ClassRoomDAO classRoomDAO){
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassName("12A1");
		classRoom.setNumberMember(22);
		classRoomDAO.saveClassRoom(classRoom);
	}

	private static void getClassById(ClassRoomDAO classRoomDAO){
		ClassRoom classRoom = classRoomDAO.getClassRoomById(1l);
		System.out.println(classRoom.toString());
	}
}
