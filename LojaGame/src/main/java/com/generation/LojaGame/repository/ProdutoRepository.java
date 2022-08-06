package com.generation.LojaGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.LojaGame.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository <ProdutoModel,Long> {
	public List <ProdutoModel> findAllByProdutoContainingIgnoreCase(@Param("produto") String produto);
	

}
