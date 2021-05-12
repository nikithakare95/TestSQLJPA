package com.example.DepenInject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NikitaController {

	@Autowired
	NikitaInterface repo;

	@RequestMapping("first")
	public String first() {
		return "first.html";

	}

	@RequestMapping("/addNikita")

	public String addNikita(Nikita niki) {
		repo.save(niki);
		return "first.html";
	}

	@RequestMapping("/getData")

	public ModelAndView getData(@RequestParam Integer aid) {
		ModelAndView mv = new ModelAndView("showdata.jsp");
		Nikita niki = repo.findById(aid).orElse(null);

		System.out.println(repo.findByatech("null"));
		System.out.println(repo.findByAidGreaterThan(301));
		System.out.println(repo.findByatechSorted("docker"));

		mv.addObject("obj", niki);
		return mv;

	}

	// commenting this out for applying restriction to get only xml output
	// //@RequestMapping("/data")//this is to make world wide aid and rest url

	// @RequestMapping(path="/data", produces= {"application/XML"})
	/*
	 * @RequestMapping(path="/data")
	 * 
	 * @ResponseBody
	 */

	@PostMapping(path = "/data")
	@ResponseBody
	public Nikita addNikita1(Nikita niki) {
		return repo.save(niki);

	}

	@PutMapping(path = "/data")
	@ResponseBody
	public Nikita addNikitaput(Nikita niki) {
		return repo.save(niki);

	}

	@GetMapping(path = "/data")
	@ResponseBody
	public List<Nikita> getData() {
		return repo.findAll();
	}

	@DeleteMapping(path = "/data")
	@ResponseBody
	public String deleteData(Integer aid) {
		List<Nikita> n = repo.findByAidGreaterThan(aid);
		repo.deleteAll(n);
		return "deleted";
	}

	@RequestMapping("/data/{aid}") // this is to make world wide aid and rest url
	@ResponseBody
	public Optional<Nikita> getData(@PathVariable("aid") int aid) {
		return repo.findById(aid);
		// we can also remove all these response body annotation and can add
		// RestController annotation
	}
}
