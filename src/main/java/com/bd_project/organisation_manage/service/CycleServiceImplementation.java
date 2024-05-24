package com.bd_project.organisation_manage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.bd_project.organisation_manage.model.Section;
import com.bd_project.organisation_manage.model.Cycle;
import com.bd_project.organisation_manage.model.SectionIdClass;
import com.bd_project.organisation_manage.repository.CycleRepository;
import com.bd_project.organisation_manage.repository.GradeRepository;
import com.bd_project.organisation_manage.repository.SectionRepository;
import com.bd_project.organisation_manage.model.Grade;

@Service
@AllArgsConstructor
public class CycleServiceImplementation implements CycleService {
	
	private CycleRepository cyclerepository;
	private GradeRepository gradeRepository;
	private SectionRepository sectionRepository;

    @Override
	public Cycle createCycle(Integer gradeId, Integer sectionId, String sectionName)
    {
		Grade grade = gradeRepository.findByGradeId(gradeId);
		Section section = sectionRepository.findBySectionIdAndSectionName(sectionId, sectionName);

        Cycle cycle = new Cycle();

		cycle.setCycleGrade(grade);
		cycle.setCycleSection(section);

        return cyclerepository.save(cycle);
    }

	@Override
	public Cycle createCycle(Integer gradeId, SectionIdClass sectionIdClass)
    {
		Grade grade = gradeRepository.findByGradeId(gradeId);

		Integer sectionId = sectionIdClass.getSectionId();
		String sectionName = sectionIdClass.getSectionName();
		Section section = sectionRepository.findBySectionIdAndSectionName(sectionId, sectionName);

        Cycle cycle = new Cycle();

		cycle.setCycleGrade(grade);
		cycle.setCycleSection(section);

        return cyclerepository.save(cycle);
    }

    @Override
	public Cycle createCycle(Cycle cycle) {
		// TODO Auto-generated method stub
		return cyclerepository.save(cycle);
	}

    @Override
	public List<Cycle> indexCycle() {
		// TODO Auto-generated method stub
		return cyclerepository.findAll();
	}
	
	@Override
    public Cycle findCycle(Integer cycleId)
    {
        Cycle cycle = cyclerepository.findByCycleId(cycleId);

        return cycle;
    }

	@Override
    public Cycle modifyCycle(Integer cycleId, Integer gradeId, SectionIdClass sectionIdClass)
    {
        Cycle cycle = cyclerepository.findByCycleId(cycleId);

		Grade grade = gradeRepository.findByGradeId(gradeId);

		Integer sectionId = sectionIdClass.getSectionId();
		String sectionName = sectionIdClass.getSectionName();
		Section section = sectionRepository.findBySectionIdAndSectionName(sectionId, sectionName);

		cycle.setCycleGrade(grade);
		cycle.setCycleSection(section);

        return cyclerepository.save(cycle);
    }

	@Override
    public Cycle modifyCycle(Integer cycleId, Integer gradeId, Integer sectionId, String sectionName)
    {
        Cycle cycle = cyclerepository.findByCycleId(cycleId);

		Grade grade = gradeRepository.findByGradeId(gradeId);
		Section section = sectionRepository.findBySectionIdAndSectionName(sectionId, sectionName);

		cycle.setCycleGrade(grade);
		cycle.setCycleSection(section);

        return cyclerepository.save(cycle);
    }

	@Override
    public Cycle deleteCycle(Integer cycleId)
    {
        Cycle cycle = cyclerepository.findByCycleId(cycleId);

        cyclerepository.deleteById(cycleId);

        return cycle;
    }

    @Override
    public void deleteAllCycle()
    {
        cyclerepository.deleteAll();
    }
}
