package com.amazon.springapi.config;

import com.amazon.springapi.entity.home.*;
import com.amazon.springapi.repository.home.*;
import com.amazon.springapi.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableMongoRepositories(basePackageClasses = {
        CategoryRepository.class,
        DiscoverRepository.class,
        SellersRepository.class,
        UserRepository.class,
        Products.class
})
@Configuration
public class MongoDBConfig {


    //  ApplicationRunner
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        DiscoverRepository discoverRepository,
                                        SellersRepository sellersRepository,
                                        CareProductsRepository careProductsRepository,
                                        ProductsRepository productsRepository
    ) {

        return strings -> {
//            (add(""),add(")
            ArrayList<String> homeCategoryUrls = new ArrayList(
                    Arrays.asList(
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/July/amazonbasics_520x520._SY304_CB442725065_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/amazonglobal/images/email/asins/DURM-2307572AF7CDC91G._V535755378_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Electronics_1x._SY304_CB432774322_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Events/2020/PrimeDay/Fuji_Dash_PD_Nonprime__1x._SY304_CB403084762_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_PC_1x._SY304_CB431800965_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Beauty_1x._SY304_CB432774351_.jpg",
                            "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2020/May/Dashboard/Fuji_Dash_Deals_1x._SY304_CB430401028_.jpg"
                    )
            );

            String[] titles = {
                    "AmazonBasics",
                    "Shop by Category",
                    "Electronics",
                    "Shop top categories",
                    "Computers & Accessories",
                    "Beauty picks",
                    "Deals & Promotions"
            };

            List categories = new ArrayList();
            categories = IntStream
                    .range(0, homeCategoryUrls.size())
                    .mapToObj(i -> {
                        return new Category(i, titles[i], homeCategoryUrls.get(i), i == 0 || i == 2 || i == 3);
                    })
                    .collect(Collectors.toList());

            categoryRepository.saveAll(categories);


            String[] discoverItems = new String[]{
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Projects/HelpPage/BubbleShoveler/English/Fuji_Bubble_8Languages_en_US_updated_1x._CB445837675_.png",
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/October/BubbleShoveler/AIS_Bubble_Currency_en_US_1X._CB451228332_.jpg",
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/October/BubbleShoveler/AIS_Bubble_SecurePayment_en_US_1X._CB451228335_.jpg",
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/October/BubbleShoveler/AIS_Bubble_ImportFees_en_US_1X._CB451228332_.jpg",
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/October/BubbleShoveler/AIS_Bubble_TrackPackage_en_US_1X._CB451228335_.jpg",
                    "https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/October/BubbleShoveler/AIS_Bubble_247CS_en_US_1X._CB451228332_.jpg"

            };

            List discover = new ArrayList();
            int i = 0;
            for (String s : discoverItems) {
                discover.add(new Discover(i++, s));
            }

            discoverRepository.saveAll(discover);

            List sellers = new ArrayList();

            String[] sellerUrls = new String[]{
                    "https://m.media-amazon.com/images/I/41KL+iXUXCL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51G8LfsNZzL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/31i3tpuXxxL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41XlyY4EvQL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41W5-duvLkL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41g0C69FbvL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41tQ9dniedL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41bCxnHksnL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41GGPRqTZtL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41Pf-FgUROL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41LO2OX6pRL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41cEMMExIoL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/413g5VksS2L._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/31qwualUaLL._AC_SY200_.jpg"
            };

            for (i = 0; i < sellerUrls.length; i++) {
                sellers.add(new Sellers(i, sellerUrls[i]));
            }

            sellersRepository.saveAll(sellers);


            List careProducts = new ArrayList();

            String[] cp = new String[]{
                    "https://m.media-amazon.com/images/I/41Z7qvCN+UL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41yn8u3qJPL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51+8z0H7zGL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51tyP0EgjUL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/41RNHlao-eL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51MQYQ+9lxL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51BQ1hohpJL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51EJjGyLVpL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/414HE5yOdoL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/31l214ak+LL._AC_SY200_.jpg",
                    "https://m.media-amazon.com/images/I/51WEIiwofyL._AC_SY200_.jpg"
            };

            for (i = 0; i < cp.length; i++) {
                careProducts.add(new CareProducts(i, cp[i]));
            }

            careProductsRepository.saveAll(careProducts);


            //            UUID.randomUUID().toString()

            productsRepository.save(
                    new Products(
                            "Amazon Top Sellers",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/41Z7qvCN+UL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41yn8u3qJPL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51+8z0H7zGL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51tyP0EgjUL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41RNHlao-eL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51MQYQ+9lxL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51BQ1hohpJL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51EJjGyLVpL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/414HE5yOdoL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31l214ak+LL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51WEIiwofyL._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Top Beauty & Personal Care products",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/41KL+iXUXCL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51G8LfsNZzL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31i3tpuXxxL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41XlyY4EvQL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41W5-duvLkL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41g0C69FbvL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41tQ9dniedL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41bCxnHksnL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41GGPRqTZtL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41Pf-FgUROL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41LO2OX6pRL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41cEMMExIoL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/413g5VksS2L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31qwualUaLL._AC_SY200_.jpg"
                            )
                    )
            );


            productsRepository.save(
                    new Products(
                            "Must have Wireless products",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/41PYkNWSrAL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41TEawIMRfL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/310bMKQjT5L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31R4prWMk0L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41WOalZ1N5L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51EXcNKQgoL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/413BYCci6NL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/4178UF1W9NL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31YGiracCNL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41Lv8P3IcVL._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Stuffed Animals & Toys under $10",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/512wF3yP3FL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41-7l-po+EL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41XCql8cjsL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41IrQCmYA+L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41+7ZmvKlUL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51wO0e5gXXL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31y8TMTwRIL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/410IWzsZhvL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51AaJPOD4qL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41j+wOpGjEL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41ZmuuKMtmL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41gU8tflgcL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41ABnWmX0eL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41F9RVTMUyL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/417ENa7Wl2L._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Best Sellers in Baby",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/41RGrXACv8L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41+tceVy64L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31WLusUnqkL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31BrpSyGV3L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51G6gwpEvdL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51roA9wBHJL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41b5I86kihL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51mNDKg0DeL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41bEkkjIKOL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41g-gVqoCaL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31NlEBHSgoL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/310cWWGXoBL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31eP4P23zkL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31fx5WTzQaL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41YMe3DHAZL._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Our favorite Toys",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/51d5cqa2fVL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51-wsV9iCqL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51aIDYrc84L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51g0tsYZE-L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41-UBiLdXbL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41-UBiLdXbL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41ruvOU1PcL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41MYebOo+lL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/515i-dyW3rL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41vcxpLL8aL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51-hpAEJSaL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51IUjJiHUFL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51Pi7lymIxL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51VG6vB8ESL._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Home Décor Under $20",
                            Arrays.asList(
                                    "https://m.media-amazon.com/images/I/21dvL73e4LL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/411lLGHkbYL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41gT9mzRM8L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/2106xsNjy4L._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41Qn+zjTjrL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/5195MBwUjdL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41CHGomCxrL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/21OX--nCrrL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/31hjtrnA6WL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51MxE9U3lCL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51l3cO7zsFL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/41F6+6aEaTL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51Ruuka2tNL._AC_SY200_.jpg",
                                    "https://m.media-amazon.com/images/I/51mlcHD5HmL._AC_SY200_.jpg"
                            )
                    )
            );

            productsRepository.save(
                    new Products(
                            "Best sellers in Kindle eBooks",
                            Arrays.asList(
                                    "https://images-na.ssl-images-amazon.com/images/I/91SnTS%2BBWSL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81AFDpfa9gL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81FJvwYyqgL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/910lSbCMclL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/817tRypfAiL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81IVbnUKbqL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81MViNwWwRL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81Qwr%2BRiAuL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/91cToRhgT6L.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81FYavYdIpL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/91zZMyUZOfL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/91giQulzYFL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/91abOjluAIL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/91giQulzYFL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81F4NU78sbL.__BG0,0,0,0_FMpng_AC_SY220_.jpg",
                                    "https://images-na.ssl-images-amazon.com/images/I/81Zn%2B4DZqOL.__BG0,0,0,0_FMpng_AC_SY220_.jpg"
                    )
            ));

        };
    }
}
