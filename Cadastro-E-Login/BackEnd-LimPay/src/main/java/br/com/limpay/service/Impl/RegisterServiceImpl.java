package br.com.limpay.service.Impl;

import br.com.limpay.domain.Register;
import br.com.limpay.repository.RegisterRepository;
import br.com.limpay.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
    }

    @Override
    public Register registerUser(Register register){
        if (registerRepository.findByCpf(register.getCpf()) == null){
            return registerRepository.save(register);
        } else {
            throw new IllegalArgumentException("Usuario com CPF ja cadastrado!");
        }
    }
}
