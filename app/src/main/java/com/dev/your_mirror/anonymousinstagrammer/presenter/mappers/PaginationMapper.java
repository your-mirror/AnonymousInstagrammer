package com.dev.your_mirror.anonymousinstagrammer.presenter.mappers;

import com.dev.your_mirror.anonymousinstagrammer.model.dto.PaginationDTO;
import com.dev.your_mirror.anonymousinstagrammer.model.dto.UserDTO;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.Pagination;
import com.dev.your_mirror.anonymousinstagrammer.presenter.view_objects.User;

import rx.functions.Func1;


public class PaginationMapper implements Func1<PaginationDTO, Pagination> {
    @Override
    public Pagination call(PaginationDTO paginationDTO) {
        Pagination pagination =  paginationDTO != null
            ?   new Pagination(paginationDTO.getNextUrl(), paginationDTO.getNextMaxId())
            :   null;

        return pagination;
    }
}
