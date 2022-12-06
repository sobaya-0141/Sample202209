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

    var viewModel : SearchCatViewModel

    @Published private(set) var state: [SearchCatResponseItem] = []
    var hasNextPage: Bool = false

    init(wrapped: SearchCatViewModel) {
        viewModel = wrapped
        fetchCats()
    }
    
    func fetchCats() {
        (viewModel.catData.asPublisher() as AnyPublisher<PagingDataKt, Never>)
            .receive(on: RunLoop.main)
            .sink{ (cat) in
                do {
                    guard let list = try (cat as? Array<SearchCatResponseItem>)?.compactMap({ $0 as? SearchCatResponseItem }) else {
                        return
                    }
                    
                    self.state = list
                    self.hasNextPage = list.count == 10
                } catch {
                    print(error.localizedDescription)
                }
            }
    }
}
