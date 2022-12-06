import SwiftUI
import shared

struct SearchCatView: View {
//    @StateObject private var viewModel = SearchCatViewModel()

    var body: some View {
        List {
//            ForEach(viewModel.state, id: \.id) { cat in
//                if #available(iOS 15.0, *) {
//                    AsyncImage(url: URL(string: cat.url)) { image in
//                        image.resizable()
//                    } placeholder: {
//                        ProgressView()
//                    }
//                    .frame(width: 240, height: 126)
//                } else {
//                    // Fallback on earlier versions
//                }
//            }.onAppear {
//                viewModel.fetchCats()
//            }
        }
    }
}

//final class SearchCatViewModel: ObservableObject {
//    @Published var state: FlowResult
//    let viewModel = ViewModels().getSearchCatViewModel()
//
//    init() {
//        viewModel.catData.asPublisher().self.sink(receiveValue: { [weak self] catData in
//            self?.state = catData
//        })
//    }
//}
