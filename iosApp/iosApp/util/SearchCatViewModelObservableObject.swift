//
//  SearchCatViewModelObservableObject.swift
//  iosApp
//
//  Created by 霜重 健児 on 2022/11/09.
//  Copyright © 2022 orgName. All rights reserved.
//
import Foundation
import Combine
import shared

public class SearchCatViewModelObservableObject : ObservableObject {

    var viewModel : FeaturesSearchCatViewModel

    @Published private(set) var state: [SearchCatResponseItem] = []
    var hasNextPage: Bool = false

    init(wrapped: FeaturesSearchCatViewModel) {
        viewModel = wrapped
        fetchCats()
    }
    
    func fetchCats() {
        (viewModel.catData.asPublisher() as AnyPublisher<PagingDataKt, Never>)
            .receive(on: RunLoop.main)
            .sink{ (completion) in
            }
            receiveValue: { (cat) in
                guard let list = (cat as? Array<SearchCatResponseItem>)?.compactMap({ $0 as? SearchCatResponseItem }) else {
                    return
                }
                
                self.state = list
                self.hasNextPage = list.count == 10
           }
    }
}
