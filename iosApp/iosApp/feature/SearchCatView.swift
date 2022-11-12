import SwiftUI
import shared

struct SearchCatView: View {
    @ObservedObject var viewmodel = ViewModels().getSearchCatViewModel().asObserveableObject()

    var body: some View {
        List {
            ForEach(viewmodel.state, id: \.id) { cat in
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string: cat.url)) { image in
                        image.resizable()
                    } placeholder: {
                        ProgressView()
                    }
                    .frame(width: 240, height: 126)
                } else {
                    // Fallback on earlier versions
                }
            }.onAppear {
                viewmodel.fetchCats()
            }
        }
    }
}
