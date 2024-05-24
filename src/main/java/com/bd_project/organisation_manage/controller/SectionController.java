package com.bd_project.organisation_manage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.bd_project.organisation_manage.model.Section;
import com.bd_project.organisation_manage.model.SectionIdClass;
import com.bd_project.organisation_manage.service.SectionService;

import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/section")
@AllArgsConstructor
@CrossOrigin("*")
public class SectionController {

	private SectionService sectionservice;
	
	@PostMapping("/creer")
	public String createSection(@RequestBody Section section) {
        Section section2 = sectionservice.createSection(section);

        if(section2 == null)
            return "";

		return "Ajout d'une nouvelle section reussi !";
	}
	
	@PostMapping("/create/{sectionName}")
	public String create(@PathVariable String sectionName)
    {
        Section section = sectionservice.createSection(sectionName);

        if(section == null)
            return "";

		return "Ajoût effectué";
    }
	
	@GetMapping("/index")
	public List<Section> indexSection(){
		return sectionservice.indexSection();
	}

	@GetMapping("/read/{sectionId}/{sectionName}")
    public Section read(@PathVariable Integer sectionId, @PathVariable String sectionName)
    {
        Section section = sectionservice.findSection(sectionId, sectionName);

        return section;
    }

    public Section read(@RequestBody SectionIdClass sectionIdClass)
    {
        Section section = sectionservice.findSection(sectionIdClass);

        return section;
    }

	@DeleteMapping("/delete/{sectionId}/{sectionName}")
    public Section delete(@PathVariable Integer sectionId, @PathVariable String sectionName)
    {
        Section section = sectionservice.deleteSection(sectionId, sectionName);

        return section;
    }

    public Section delete(@RequestBody SectionIdClass sectionIdClass)
    {
        Section section = sectionservice.deleteSection(sectionIdClass);

        return section;
    }

	@DeleteMapping("/delete")
    public String delete()
    {
        sectionservice.deleteAllSection();

		return "Table vidée";
    }
}
