package com.smfssilva.curso.boot.service;

import com.smfssilva.curso.boot.dao.FuncionarioDao;
import com.smfssilva.curso.boot.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Transactional(readOnly = false)
    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
