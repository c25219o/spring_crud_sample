package jp.co.opst.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.opst.spring.params.UserForm;
import jp.co.opst.util.literal.LengthUtil;

@Controller
public class ValidationController {

	// ModelAttributeバージョン
	@RequestMapping(value = "check1", method = RequestMethod.POST)
	public String validation1(@ModelAttribute @Valid UserForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("form", form);
			return "admin/top";
		} else {
			return "redirect:http://google.com";
		}
	}

	// RequestParamバージョン
	@RequestMapping(value = "check2", method = RequestMethod.POST)
	public String validation2(@RequestParam @Valid String parameter, BindingResult result, Model model) {

		if (LengthUtil.isEmpty(parameter)) {
			model.addAttribute("parameter", parameter);
			return "admin/top";
		} else {
			return "redirect:http://google.com";
		}
	}

}
