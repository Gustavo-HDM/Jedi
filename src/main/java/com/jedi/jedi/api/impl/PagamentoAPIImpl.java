package com.jedi.jedi.api.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedi.jedi.api.PagamentoAPI;
import com.jedi.jedi.dto.PagamentoResponseDTO;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class PagamentoAPIImpl implements PagamentoAPI{
	
	@Autowired
	private OkHttpClient client;
	
	@Override
	public PagamentoResponseDTO getMensalidade() {
		Request request = new Request.Builder().url("http://localhost:8082/mensalidade").build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(response.body().toString());
		return null;
	}
}